package com.example.uzauto;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class EditTextYozuvi {
  public void oqGaboyash(EditText editText){
      editText.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {

          }

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {

          }

          @Override
          public void afterTextChanged(Editable s) {

              try {

              } catch (Exception e) {
                  System.out.println("Error " + e.getMessage());

              }
          }
      });
  }
}
