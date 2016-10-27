package com.a07150931.lxc.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AlertDialog dialog1;
    private AlertDialog.Builder builder;
    private TextView tView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tView = (TextView) this.findViewById(R.id.textView1);

        Button button1 = (Button) this.findViewById(R.id.button1);
        Button button2 = (Button) this.findViewById(R.id.button2);
        Button button3 = (Button) this.findViewById(R.id.button3);
        Button button4 = (Button) this.findViewById(R.id.button4);
        Button button5 = (Button) this.findViewById(R.id.button5);
        Button button6 = (Button) this.findViewById(R.id.button6);
        Button button7 = (Button) this.findViewById(R.id.button7);

        View.OnClickListener listener = new View.OnClickListener(){

            public void onClick(View v){

                switch (v.getId()){
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }
            }
        };
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
    }

    public void dialog1(){

        dialog1 = new AlertDialog.Builder(this).create();
        dialog1.setTitle("提示");
        dialog1.setMessage("确认退出吗？");
        dialog1.setIcon(android.R.drawable.ic_dialog_alert);

        //创建按键监听；
        DialogInterface.OnClickListener listener1 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(which == DialogInterface.BUTTON_POSITIVE){
                    dialog.dismiss();
                    MainActivity.this.finish();
                }else if(which == DialogInterface.BUTTON_NEGATIVE){
                    dialog.dismiss();
                }
            }
        };

        dialog1.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener1);
        dialog1.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener1);
        dialog1.show();
    }

    public void dialog2(){
        dialog1 = new AlertDialog.Builder(this).create();
        dialog1.setTitle("调查");
        dialog1.setMessage("你平时忙吗？");
        dialog1.setIcon(android.R.drawable.ic_dialog_info);

    //创建按键监听器；
        DialogInterface.OnClickListener listener2 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String str = "";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str = "平时很忙！";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str = "平时不是很忙！";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str ="平时不忙！";
                        break;
                }
                tView.setText(str);
            }
        };
        dialog1.setButton(DialogInterface.BUTTON_POSITIVE,"很忙",listener2);
        dialog1.setButton(DialogInterface.BUTTON_NEUTRAL,"一般",listener2);
        dialog1.setButton(DialogInterface.BUTTON_NEGATIVE,"不忙",listener2);
        dialog1.show();
    }

    public void dialog3(){

        dialog1 = new AlertDialog.Builder(this).create();
        dialog1.setTitle("请输入:");
        dialog1.setMessage("你平时忙吗？");
        dialog1.setIcon(android.R.drawable.ic_dialog_info);
        final EditText tEdit = new EditText(this);
        dialog1.setView(tEdit);

    //创建按键监听器；
        DialogInterface.OnClickListener listener3 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tView.setText("输入的是："+ tEdit.getText().toString());
            }
        };
        dialog1.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener3);
        dialog1.show();
    }

    public void dialog4(){

        final String item[] = new String[] { "北京","上海","广州" };
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mListenter = new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which] = isChecked;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,null,mListenter);
        dialog1 = builder.create();
        dialog1.setTitle("复选框");
        DialogInterface.OnClickListener listener4 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String str = "你选择了：";
                for(int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str = str + "\n" + item[i];
                    }
                }
                tView.setText(str);
            }
        };
        dialog1.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener4);
        dialog1.show();
    }

    public void dialog5(){
        final String item[] = new String[]{"北京","上海","广州"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnClickListener sListenter = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for(int i=0;i<bSelect.length;i++){
                    if(i!=which){
                        bSelect[i]=false;
                    }else{
                        bSelect[i]=true;
                    }
                }
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,sListenter);
        dialog1 = builder.create();
        dialog1.setTitle("单选框");
        DialogInterface.OnClickListener listener5 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String str = "你选择了：";
                for(int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str = str + "\n" +item[i];
                    }
                }
                tView.setText(str);
            }
        };
        dialog1.setButton(AlertDialog.BUTTON_POSITIVE,"确定",listener5);
        dialog1.show();
    }

    public void dialog6(){
        final String item[] = new String[]{"北京","上海","广州"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnClickListener sListenter = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String str = "你选择了："+ item[which];
                tView.setText(str);
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setItems(item,sListenter);
        dialog1 = builder.create();
        dialog1.setTitle("列表框");
        DialogInterface.OnClickListener listenter6 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog1.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listenter6);
        dialog1.show();
    }

    public void dialog7(){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.mylayout,null);
        final EditText tEdit = (EditText) layout.findViewById(R.id.editText1);
        dialog1 = new AlertDialog.Builder(this).create();
        dialog1.setTitle("自定义布局");
        dialog1.setView(layout);
        DialogInterface.OnClickListener listener7 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                tView.setText("输入的是："+ tEdit.getText().toString());
            }
        };
        dialog1.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener7);
        dialog1.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener7);
        dialog1.show();

    }


}
