#ifndef CODETEXTEDIT_H
#define CODETEXTEDIT_H

#include <QWidget>

namespace Ui {
class CodeTextEdit;
}

class CodeTextEdit : public QWidget
{
    Q_OBJECT

public:
    explicit CodeTextEdit(QWidget *parent = nullptr);
    ~CodeTextEdit();

private slots:
    void textEditHScrollBarChanged();
    void scrollBarChanged();
    void textEditVScrollBarChanged();
    void textBrowserVScrollBarChanged();
    void onTextChanged();

private:
    Ui::CodeTextEdit *ui;
    void initConnect();
    void initFont();
    void initHighlighter();
};

#endif // CODETEXTEDIT_H
