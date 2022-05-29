set wshshell=wscript.createobject("wscript.shell")
wshshell.AppActivate""
for i=1 to 100
wscript.sleep 100
wshshell.sendKeys "^v"
wshshell.sendKeys i
wshshell.sendKeys "%s"
next