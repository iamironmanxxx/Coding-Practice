preorder=[] 
nodeSet={}
root=None
ptr = 0
class Node: 
  def __init__(self,value):
    self.left=None
    self.right=None
    self.key=value
def buildTree(inorder, start,end,n):
  global ptr
  if ptr>=n or start>end:
    return None
  rootIndex=nodeSet[preorder[ptr]]
  root=Node(inorder[rootIndex])
  ptr+=1
  root.left=buildTree(inorder,start,rootIndex-1,n)
  root.right=buildTree(inorder,rootIndex+1,end,n)
  return root
def postOrder(root): 
  if root!=None :
    postOrder(root.left)
    postOrder(root.right)
    print(root.key,end= " ")

if __name__=="__main__" :
  n=int(input())
  inorder=[]
  preorder=[]
  inpStr=input().split(" ")
  count=0
  print(n)
  while inpStr != "\n" :
    if int(count / n)==0:
      inorder.append(inpStr[0])
    else :
      preorder.append(inpStr[0])
    try:
      inpStr=input().split(" ")
    except EOFError :
      break
    count+=1

  print(inorder)
  print(preorder)

  i=0
  for x in inorder :
    nodeSet[x]=i
    i+=1
  root=buildTree(inorder,0,n-1,n)
  postOrder(root)