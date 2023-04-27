#include "highlight.h"
#include <QtCore5Compat>


Highlight::Highlight(QTextDocument *parent): QSyntaxHighlighter(parent)
{
    //对于普通文本
    addNormalTextFormat();
    //对于数字
    addNumberFormat();
    //对于字符串
    addStringFormat();
    //对于注释
    addCommentFormat();
}

void Highlight::addNormalTextFormat()
{
    textRegExp("[a-z0-9A-Z]+", QColor(0,0,0));
}

void Highlight::addNumberFormat()
{
    textRegExp("\\b\\d+|\\d+\\.\\d+\\b", QColor(250,80,50));
}

void Highlight::addStringFormat()
{
    //''
    textRegExp("'[^']*'", QColor(0,180,180));
    //""
    textRegExp("\"[^\"]*\"", QColor(0,180,180));
    //``
    textRegExp("`[^`]*`", QColor(0,180,180));
}

void Highlight::addCommentFormat()
{
    // //data
    textRegExp("\\/\\/.*$", Qt::darkGreen);
    // /*data*/
    textRegExp("\\/\\*[^*]*\\*+(?:[^/*][^*]*\\*+)*\\/", Qt::darkGreen);
}

void Highlight::textRegExp(QString regExp, QColor color)
{
    HighlightRule rule;
    rule.parrern = QRegExp(regExp);
    QTextCharFormat anyFormatting;
    anyFormatting.setFont(QFont(mFontFamily, mFontSize));
    anyFormatting.setForeground(color);
    rule.format = anyFormatting;
    highlightRules.append(rule);
}

void Highlight::highlightBlock(const QString &text)
{
    foreach (const HighlightRule &rule, highlightRules) {
        QRegExp regExp(rule.parrern);
        int index = regExp.indexIn(text);
        while (index >= 0){
            int length = regExp.matchedLength();
            setFormat(index, length, rule.format);
            index = regExp.indexIn(text, index+length);
        }
    }
    currentBlockState();
    setCurrentBlockState(0);
    // /*
    QRegExp commentStartRegExp("\\/\\*");
    // */
    QRegExp commentEndRegExp("\\*\\/");

    //高亮格式
    QTextCharFormat multiLineCommentFormat;
    multiLineCommentFormat.setFont(QFont(mFontFamily, mFontSize));
    multiLineCommentFormat.setForeground(Qt::darkGreen);

    int startIndex = commentStartRegExp.indexIn(text);

    while (startIndex >= 0){
        int endIndex = commentEndRegExp.indexIn(text);
        int commentLength;
        if (endIndex == -1){//没有结束位置
            commentLength = text.length()-startIndex;
        } else {//有结束位置
            commentLength = endIndex-startIndex+commentEndRegExp.matchedLength();
        }
        setFormat(startIndex, commentLength, multiLineCommentFormat);
        startIndex = commentStartRegExp.indexIn(text, commentLength+startIndex);
    }
}

