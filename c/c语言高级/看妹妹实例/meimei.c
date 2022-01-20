#include <stdio.h>
#include <graphics.h>
#include <time.h>
#include <mmsyscom.h>

#define WIN_SIZE 500//窗口大小
#define WIN_HALF (WIN_SIZE / 2)
#pragma comment(lib,"Winmm.lib")

int meimei = 10;
//这里控制色图数量
IMAGE spaceMan[10];
void music()
{
	mciSendString("open ./images/music.mp3", NULL, 0, NULL);
	mciSendString("play ./images/music.mp3", NULL, 0, NULL);
}
void loadImg()
{
	int i;
	char fileName[50] = { 0 };
	for (i = 0; i < meimei; i++)
	{
		//这里换色图路径
		//注意这里的human (%d).jpg路径一定要输对不然打不开色图
		sprintf_s(fileName, "./images/human (%d).jpg", i + 1);
		loadimage(spaceMan + i, fileName, 140, 130);
	}
}
void setTextStyle(int h, int w, const char *faceName)
{
	LOGFONT f = { 0 };
	f.lfHeight = h;
	f.lfWeight = w;
	strcpy(f.lfFaceName, faceName);
	settextstyle(&f);
}
//控制动画
void animation()
{
	static DWORD t1 = clock();
	DWORD t2 = clock();
	static int i = 0;
	if (t2 - t1 > 400) {
		i++;
		if (i > meimei) {
			i = 0;
		}
		t1 = t2;
	}

	putimage(WIN_HALF - 60, WIN_HALF - 50, spaceMan + i);
}
//其他界面绘制
void gameDraw()
{

	//定义背景颜色
	setbkcolor(RGB(223, 230, 240));
	//清除原来挡住背景的颜色
	cleardevice();
	setbkmode(TRANSPARENT);
	//弄个圆盘
	setlinecolor(RGB(68, 68, 68));
	setlinestyle(PS_SOLID, 40);
	setfillcolor(RGB(223, 230, 240));
	fillellipse(0, 0, WIN_SIZE, WIN_SIZE);
	//绘制线条
	setlinecolor(BLACK);
	setlinestyle(PS_SOLID, 4);
	//竖线
	line(WIN_HALF - 30, 20, WIN_HALF - 30, 130);
	//横线
	line(WIN_HALF - 195, WIN_HALF - 120, WIN_HALF + 195, WIN_HALF - 120);
	line(WIN_HALF - 195, WIN_HALF + 120, WIN_HALF + 195, WIN_HALF + 120);
	//获取系统时间
	time_t curTime = time(NULL);
	struct tm * humanTime = localtime(&curTime);
	char buf[40] = { 0 };
	//时间小时和分钟
	sprintf_s(buf, "%d:%d", humanTime->tm_hour, humanTime->tm_min);
	outtextxy(WIN_HALF - 145, WIN_HALF - 115, buf);
	sprintf_s(buf, "%d", humanTime->tm_sec);
	outtextxy(335, 160, buf);
}
int main()
{
	initgraph(500, 500);
	//定义文字颜色
	settextcolor(BLACK);
	//调用封装的代码实现文字的大小字体
	setTextStyle(55, 23, "Arial");
	//文字的位置和文字
	outtextxy(50, 50, "90%");
	//调用图片
	loadImg();
	BeginBatchDraw();//双缓冲绘图
	music();
	//循环图片实现动画效果
	while (true) {

		gameDraw();
		animation();
		
		FlushBatchDraw();
	}
	//如果不加int a = 的话汇报错
	int a = getchar();
	return 0;
}