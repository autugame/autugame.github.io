#ifndef HIGHLIGHT_H
#define HIGHLIGHT_H

#include <QObject>
#include <QSyntaxHighlighter>
#include <QtCore5Compat>

class Highlight: public QSyntaxHighlighter
{
public:
    explicit Highlight(QTextDocument *parent = nullptr);
protected:
    void highlightBlock(const QString &text);
private:

    QString mFontFamily = "Consolas";
    int mFontSize = 14;
    struct HighlightRule{
        QRegExp parrern;
        QTextCharFormat format;
    };
    QVector<HighlightRule> highlightRules;

    void addNormalTextFormat();
    void addNumberFormat();
    void addStringFormat();
    void addCommentFormat();

    void textRegExp(QString regExp, QColor color);
};

#endif // HIGHLIGHT_H
