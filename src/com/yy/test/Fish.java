//package com.yy.test;
//
//public class Fish {
//	
//	public catchFish(){
////		#include <iostream>
////		#include <cstring>
////		#define MAXN 26
////		using namespace std;
//		int t[MAXN]={0},f[MAXN],F[MAXN],d[MAXN],ans[MAXN],ANS[MAXN];
//		//ans为枚举过程中记录每个湖应该停留时间，ANS为最优的结果
//		int main(){
//			int h,n,i,time,max,j,sum,p,k;
//			while (cin>>n,n)
//			{
//				cin>>h;
//				h = h*12;
//				for (i = 0;i < n;i++) cin>>F[i];
//				for (i = 0;i < n;i++) cin>>d[i];
//				for (i = 1;i < n;i++)
//				{
//					cin>>time;
//					t[i] = time + t[i-1];//统计走到某个湖的时间
//				}
//				memset(ANS,0,sizeof(ANS));
//				for (max = 0 , i = 1;i <= n;i++)//枚举，max记录最多鱼的数目
//				{
//					memset(ans,0,sizeof(ans));
//					for (j = 0; j < i;j++)
//					{
//						f[j] = F[j];
//					}
//					for (j = 0,sum = 0;j < h - t[i-1];j++)//减去在湖之间所走的时间，相当于瞬间转移
//					{
//						for (p = 0,k = 1;k < i;k++)
//						{
//							if (f[k] > f[p])
//							{
//								p = k; //p标记初始状态下鱼最多的水池
//							}
//						}
//						if (f[p] <= 0)
//						{
//							ans[0]+=h-t[i-1]-j;
//							break;
//						}
//						sum+=f[p];//计算钓到鱼的总数
//						f[p]-=d[p];//水池里面鱼减少后的数目
//						ans[p]++;//对应池塘钓鱼时间+1
//					}
//					if (sum > max)
//					{
//						max = sum;
//						memcpy(ANS,ans,sizeof(ans));
//					}
//					if (sum == max)
//					{
//						for (j = 0;j < i;j++)
//						{
//							if (ans[j] != ANS[j])
//							{
//								break;
//							}
//						}
//						if (ans[j] > ANS[j])
//						{
//							memcpy(ANS,ans,sizeof(ans));
//						}
//					}
//				}
//				for (i = 0;i < n-1;i++)
//				{
//					cout<<ANS[i]*5<<", ";
//				}
//				cout<<ANS[n-1]*5<<endl;
//				cout<<"Number of fish expected: "<<max<<endl<<endl;	
//			}
//			return 0;	
//		}
//		
//	}
//
//}
