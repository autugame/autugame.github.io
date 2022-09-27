@echo off & title Love & setlocal enabledelayedexpansion

mode con: cols=36 lines=19

:loop

set colors=12345689abcde 

set /a rand=%random%%%13+1

set color=!colors:~%rand%,1! 

color 0%color% 

echo.  

echo. 

echo          ****          ****

echo        *******        *******

echo      ***********    ***********

echo     *************  *************

echo     ****************************

echo     ****************************

echo     ****************************

echo      **************************

echo        ***********************

echo          *******************

echo            ***************

echo              ***********

echo                *******

echo                  ***

echo                   *

echo     I love you 
echo     today is my 197days since our first kiss
echo     I want to comfort you in the rest of my life
ping 127.1 -n 2 >nul

cls

goto loop

echo. & pause > nul
这是bat的表白代码。

接下来是vbs的（中文可以改，英文不能改改了就用不了了）

const title = "我关注你很久啦"


const yourname = "嫦娥"

const question = "你最喜欢的人是谁？请在下面的方框中输入他（她）的名字。"


const info =" 你在说谎！不要逃避，实话实说。"
const scend = "你说出了你的心扉，那就向他（她）表白吧。"


dim youranswer


do


youranswer = inputbox(question, title)


if youranswer <> yourname then msgbox info, vbinformation+vbokonly, title


loop until youranswer = yourname


msgbox scend, vbinformation+vbokonly, title
————————————————
版权声明：本文为CSDN博主「m0_59036903」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/m0_59036903/article/details/120230879