//获取页面中需要操作的HTML元素
var containerDiv = document.getElementById("container");
var fractionDiv = document.getElementById("fraction");
var timeDiv = document.getElementById("time");
var startMenuDiv = document.getElementById("startMenu");
var overMenuDiv = document.getElementById("overMenu");
var reloadMenuDiv = document.getElementById("reloadMenu");

var startBtn = document.getElementById("start");
var overBtn = document.getElementById("over");
var reloadBtn = document.getElementById("reload");

//1点击开始按钮隐藏按钮并开始计时
startBtn.onclick = function(){
	//a,隐藏开始按钮
	startMenuDiv.style.display = "none";
	
	//b,开始计时
	startTimeing();
	wolfsGoGoGo();
}

function startTimeing(){
	var timeDivWidth = 180;
	var px = timeDivWidth/(60*10);//使用进度条宽度除以游戏时间
	//每0.1秒将时间进度条的宽度减少0.3像素
	var timeTask = setInterval(function(){
		timeDivWidth = timeDivWidth - px;
		//将计算后的宽度设置给时间进度条
		timeDiv.style.width = timeDivWidth+"px";
		if (timeDivWidth <= 0) {
			//表示游戏时间结束:停止计时
			clearInterval(timeTask);
			clearInterval(showWolfTask);
			//显示游戏结束和重新开始按钮
			overMenuDiv.style.display = "block";
			timeDiv.style.display = "none";
			reloadMenuDiv.style.display = "block";
		}
	},100);
}

overBtn.onclick = function(){
	window.close();
}

reloadBtn.onclick = function(){
	timeDiv.style.display = "block";
	timeDiv.style.width = "180px";
	fractionDiv.innerHTML = 0;
	overMenuDiv.style.display = "none";
	reloadMenuDiv.style.display = "none";
	startTimeing();
	wolfsGoGoGo();
}

var arrPos = [["98px","115px"],["17px","160px"],["15px","221px"],
["30px","294px"],["122px","274px"],["207px","296px"],
["200px","212px"],["187px","142px"],["100px","192px"]];

var score = 0;
var showWolfTask;
	
function wolfsGoGoGo(){
	//c,显示一只狼
	showOneWolf()
	showWolfTask = setInterval("showOneWolf()",1500);
};
	
function showOneWolf(){
	//创建一个img标签
	var img = document.createElement("img");
	//img.src = "./imgs/h5.png";
	//将img标签添加为container的子标签
	containerDiv.appendChild(img);
	//将img显示到洞口位置
	
	var index = Math.floor(Math.random()*arrPos.length);
	img.style.position = "absolute";
	img.style.left = arrPos[index][0];
	img.style.top = arrPos[index][1];
	//随机产生一只狼设置到img标签
	var wolfIndex = Math.floor(Math.random()*3);
	var wolfName = wolfIndex%2==0?"h":"x";

	//4,让狼有一个上升的过程
	var i = 0;
	var task = null;//表示狼完全显示以后得等待任务
	var hideImgTask = null;//狼下降的循环任务
	var showImgTask = setInterval(function(){
		//console.log(i);
		img.src = "./imgs/"+wolfName+i+".png";
		if (i == 5){
			//狼已经完全显示
			clearInterval(showImgTask);
			//等待一定的时间
			task = setTimeout(function(){
				hideImgTask = setInterval(function(){
					i--;
					img.src = "./imgs/"+wolfName+i+".png";
					if (i < 0){
						clearInterval(hideImgTask);
						img.remove();
					}
				},50)
			},500);
		}
		i++;
	},50);
	
	//游戏计分
	img.onclick = function(){
		clearInterval(showImgTask);
		clearTimeout(task);
		clearInterval(hideImgTask);
		//显示狼被打击的动画
		var j = 5;
		var hitTask = setInterval(function(){
			j++;
			img.src = "./imgs/"+wolfName+j+".png";
			if (j > 9){
				clearInterval(hitTask);
				img.remove();
			}
		},80);
		
		//计分
		if (wolfName == "h") {
			score = score+10;
		} else {
			score = score-10;
		}
		fractionDiv.innerHTML = score;
	}
}