#include "codetextedit.h"
#include "ui_codetextedit.h"
#include "qDebug"
#include "highlight.h"

CodeTextEdit::CodeTextEdit(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::CodeTextEdit)
{
    ui->setupUi(this);
    //绑定滚动条
    initConnect();
    //初始化字体
    initFont();
    //初始化高亮
    initHighlighter();
}

CodeTextEdit::~CodeTextEdit()
{
    delete ui;
}

void CodeTextEdit::initConnect()
{
    connect(ui->textEdit, SIGNAL(textChanged()), SLOT(onTextChanged()));
    connect(ui->textEdit->horizontalScrollBar(), SIGNAL(valueChanged(int)), this, SLOT(textEditHScrollBarChanged()));
    connect(ui->horizontalScrollBar, SIGNAL(valueChanged(int)), this, SLOT(scrollBarChanged()));
    connect(ui->textEdit->verticalScrollBar(), SIGNAL(valueChanged(int)), this, SLOT(textEditVScrollBarChanged()));
    connect(ui->textBrowser->verticalScrollBar(), SIGNAL(valueChanged(int)), this, SLOT(textBrowserVScrollBarChanged()));
}

void CodeTextEdit::initFont()
{
    QFont font("Consolas", 14);
    ui->textEdit->setFont(font);
    ui->textBrowser->setFont(font);
}

void CodeTextEdit::initHighlighter()
{
    new Highlight(ui->textEdit->document());
}

void CodeTextEdit::textEditHScrollBarChanged()
{
    ui->horizontalScrollBar->setMinimum(ui->textEdit->horizontalScrollBar()->minimum());
    ui->horizontalScrollBar->setMaximum(ui->textEdit->horizontalScrollBar()->maximum());
    ui->horizontalScrollBar->setPageStep(ui->textEdit->horizontalScrollBar()->pageStep());
    ui->horizontalScrollBar->setValue(ui->textEdit->horizontalScrollBar()->value());
}

void CodeTextEdit::scrollBarChanged()
{
    ui->textEdit->horizontalScrollBar()->setValue(ui->horizontalScrollBar->value());
}

void CodeTextEdit::textEditVScrollBarChanged()
{
    ui->textBrowser->verticalScrollBar()->setValue(ui->textEdit->verticalScrollBar()->value());
}

void CodeTextEdit::textBrowserVScrollBarChanged()
{
    ui->textEdit->verticalScrollBar()->setValue(ui->textBrowser->verticalScrollBar()->value());
}

void CodeTextEdit::onTextChanged()
{
    int lineCountOfTextEdit = ui->textEdit->document()->lineCount();
    QString text = ui->textBrowser->toPlainText();
    int lineCountOfTextBrowser = text.trimmed().split("\n").length();

    if (lineCountOfTextBrowser > lineCountOfTextEdit){
        for (int i = lineCountOfTextBrowser; i>lineCountOfTextEdit; i--){
            text.chop((QString::number(i)+"\n").length());
        }
    }else if(lineCountOfTextBrowser==1 && text.length()<1){
        text+="1\n";
    }else if(lineCountOfTextBrowser < lineCountOfTextEdit){
        for (int i=lineCountOfTextBrowser; i<lineCountOfTextEdit; i++){
            text+=QString::number(i+1)+"\n";
        }
    }
    ui->textBrowser->setMaximumWidth(25+QString::number(lineCountOfTextEdit).length()*7);
    ui->textBrowser->setText(text);
}

