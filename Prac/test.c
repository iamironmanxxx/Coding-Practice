#include <stdio.h>
int main()
{
	float x,y;
	char z;
	while(1)
	{
		if(!(scanf("%f",&x)))
		{
			break;
		}
		else 
		{
			int l=(int) x;
			if((x-l)!=0.0)
			{
				break;
			}
		}
		if(!scanf("%f",&y))
		{
			break;
		}
		//printf("%f\n",y );
		if(!scanf(" %c",&z))
		{
			break;
		}
		//printf("%c\n",z);
	}
	return 0;
}