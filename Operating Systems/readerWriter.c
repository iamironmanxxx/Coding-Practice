#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>
#define N_READERS 5
#define N_WRITERS 5
#define X 20

int shared_val=0;
int rcount=0;
int rwaiting=0;

pthread_mutex_t m = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t c_readers = PTHREAD_COND_INITIALIZER;
pthread_cond_t c_writers = PTHREAD_COND_INITIALIZER;

void* writer(void *pos)
{
	int position=*((int *)pos);
	for(int i=1;i<=X;i++)
	{
		//entry section
		pthread_mutex_lock(&m);
			while(rcount!=0)
			{
				pthread_cond_wait(&c_writers,&m);
			}
			rcount=-1;
		pthread_mutex_unlock(&m);

		//critical section
		shared_val=(int)(i*rand());
		printf("[%d] %d [%d]\n",position,shared_val,rcount);

		//exit section
		pthread_mutex_lock(&m);
			rcount=0;
			if(rwaiting>0)
			{
				pthread_cond_broadcast(&c_readers);
			}
			else
			{
				pthread_cond_signal(&c_writers);
			}
		pthread_mutex_unlock(&m);
	}
	printf("writer quitting\n");
	fflush(stdout);
	pthread_exit(0);
}

void* reader(void *pos)
{
	int position=*((int *)pos);
	for(int i=1;i<=X;i++)
	{
		//entry section
		pthread_mutex_lock(&m);
			rwaiting++;
			while(rcount==-1)
			{
				pthread_cond_wait(&c_readers,&m);
			}
			rwaiting--;
			rcount++;
		pthread_mutex_unlock(&m);

		//critical section
		printf("[%d] %d [%d]\n",position,shared_val,rcount);

		//exit section
		pthread_mutex_lock(&m);
			rcount--;
			if(rcount==0)
			{
				pthread_cond_signal(&c_writers);
			}
		pthread_mutex_unlock(&m);
	}
	printf("reader quitting\n");
	fflush(stdout);
	pthread_exit(0);
}

int main(int argc, char **argv)
{
	pthread_t readers[N_READERS];
	pthread_t writers[N_WRITERS];
	int readerIndex[N_READERS];
	int writerIndex[N_WRITERS];

	for(int i=1;i<=N_WRITERS;i++)
	{
		writerIndex[i-1]=i;
		if(pthread_create(&writers[i-1],NULL,&writer,&writerIndex[i-1]))
		{
			fprintf(stderr,"Unable to create writer thread\n");
			exit(1);
		}
	}
	
	for(int i=1;i<=N_READERS;i++)
	{
		readerIndex[i-1]=i;
		if(pthread_create(&readers[i-1],NULL,&reader,&writerIndex)!=0)
		{
			fprintf(stderr,"Unable to create reader thread\n");
			exit(1);
		}

	}

	for(int i=0;i<N_WRITERS;i++)
	{
		pthread_join(writers[i],NULL);
	}

	for(int i=0;i<N_READERS;i++)
	{
		pthread_join(readers[i],NULL);
	}

	printf("Parent Quitting\n");

	return 0;
}