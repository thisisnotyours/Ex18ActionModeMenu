package com.suek.ex18actionmodemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // 1) 버튼누르면 실행되는 메소드
    public void clickBtn(View view) {
        //액션모드 메뉴 시작하기!   어떤 상황(4가지 상황황)이 길때마다 액션모드가 발동
        //this.startActionMode();  this(MainActivity) 안써도됨.
        startActionMode(new ActionMode.Callback() {

            //액션모드메듀가 '처음' 만들어질때 1번 호출되는 메소드
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                getMenuInflater().inflate(R.menu.actionmode, menu);

                //액션모드에 추가로 줄 수 있는 설정들
                mode.setTitle("action mode");
                mode.setSubtitle("this is action mode");

                //액션모드의 배경색은 styles.xml 에서만 지정가능

                return true;    //리턴값을 반드시 true 로 해야 액션모드가 발동함
            }

            //그 다음부터 액션모드메뉴가 시작될때 마다 발동하는 메소드
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            //액션모드메뉴 아이템을 클릭했을때 발동하는 메소드(like. 옵션아이템 선택같은...)
            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

                switch (item.getItemId()){
                    case R.id.menu_aa:
                        Toast.makeText(MainActivity.this, "SHARE", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_bb:
                        Toast.makeText(MainActivity.this, "MAP", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_cc:
                        Toast.makeText(MainActivity.this, "DIALOG", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }

            //액션모드가 닫힐때 자동으로 실행되는 메소드
            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }
}
