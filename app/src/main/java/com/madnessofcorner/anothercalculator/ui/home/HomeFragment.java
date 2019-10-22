package com.madnessofcorner.anothercalculator.ui.home;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.madnessofcorner.anothercalculator.R;
import com.udojava.evalex.Expression;

import java.math.BigDecimal;
import java.util.ArrayList;


public class HomeFragment extends Fragment implements View.OnClickListener {
	private static final String TAG = "MAIN_SCREEN";

	private EditText etWorkSpace;
	private EditText etResult;

	private Button btn0;
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;
	private Button btn6;
	private Button btn7;
	private Button btn8;
	private Button btn9;

	private Button btnDot;
	private Button btnAdd;
	private Button btnMinus;
	private Button btnMul;
	private Button btnDiv;

	private Button btnEquals;
	private Button btnClear;

	private Button btnOpenBr;
	private Button btnCloseBr;

	private Button btnCorrection;

	private Button btnPi;
	private Button btnExp;

	private Button btnPercentage;



	public View onCreateView(@NonNull LayoutInflater inflater,
							 ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_home, container, false);
		etWorkSpace = root.findViewById(R.id.et_workspace);
		etWorkSpace.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			}

			@Override
			public void afterTextChanged(Editable editable) {
				doCalculateLib(etWorkSpace.getText().toString());
			}
		});
		etResult = root.findViewById(R.id.et_result);

		btn0 = root.findViewById(R.id.button0);
		btn1 = root.findViewById(R.id.button1);
		btn2 = root.findViewById(R.id.button2);
		btn3 = root.findViewById(R.id.button3);
		btn4 = root.findViewById(R.id.button4);
		btn5 = root.findViewById(R.id.button5);
		btn6 = root.findViewById(R.id.button6);
		btn7 = root.findViewById(R.id.button7);
		btn8 = root.findViewById(R.id.button8);
		btn9 = root.findViewById(R.id.button9);

		btnDot = root.findViewById(R.id.btn_dot);
		btnAdd = root.findViewById(R.id.btn_add);
		btnMinus = root.findViewById(R.id.btn_minus);
		btnMul = root.findViewById(R.id.btn_mul);
		btnDiv = root.findViewById(R.id.btn_division);
		btnEquals = root.findViewById(R.id.btn_equals);
		btnClear = root.findViewById(R.id.btn_clear);

		btnOpenBr = root.findViewById(R.id.btn_open_br);
		btnCloseBr = root.findViewById(R.id.btn_close_br);

		btnCorrection = root.findViewById(R.id.btn_correction);

		btnPi = root.findViewById(R.id.btn_pi);
		btnExp = root.findViewById(R.id.btn_exp);
		btnPercentage = root.findViewById(R.id.btn_percentage);

		btn0.setOnClickListener(this);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
		btn7.setOnClickListener(this);
		btn8.setOnClickListener(this);
		btn9.setOnClickListener(this);

		btnDot.setOnClickListener(this);
		btnAdd.setOnClickListener(this);
		btnMinus.setOnClickListener(this);
		btnMul.setOnClickListener(this);
		btnDiv.setOnClickListener(this);
		btnEquals.setOnClickListener(this);
		btnClear.setOnClickListener(this);
		btnCorrection.setOnClickListener(this);

		btnPi.setOnClickListener(this);
		btnExp.setOnClickListener(this);
		btnOpenBr.setOnClickListener(this);
		btnCloseBr.setOnClickListener(this);
		btnPercentage.setOnClickListener(this);



		return root;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.button0 : {
				etWorkSpace.setText(etWorkSpace.getText() + "0");
				break;
			}
			case R.id.button1 : {
				etWorkSpace.setText(etWorkSpace.getText() + "1");
				break;
			}
			case R.id.button2 : {
				etWorkSpace.setText(etWorkSpace.getText() + "2");
				break;
			}
			case R.id.button3 : {
				etWorkSpace.setText(etWorkSpace.getText() + "3");
				break;
			}
			case R.id.button4 : {
				etWorkSpace.setText(etWorkSpace.getText() + "4");
				break;
			}
			case R.id.button5 : {
				etWorkSpace.setText(etWorkSpace.getText() + "5");
				break;
			}
			case R.id.button6 : {
				etWorkSpace.setText(etWorkSpace.getText() + "6");
				break;
			}
			case R.id.button7 : {
				etWorkSpace.setText(etWorkSpace.getText() + "7");
				break;
			}
			case R.id.button8 : {
				etWorkSpace.setText(etWorkSpace.getText() + "8");
				break;
			}
			case R.id.button9 : {
				etWorkSpace.setText(etWorkSpace.getText() + "9");
				break;
			}

			case R.id.btn_dot: {
				etWorkSpace.setText(etWorkSpace.getText() + ".");
				break;
			}
			case R.id.btn_open_br: {
				etWorkSpace.setText(etWorkSpace.getText() + "(");
				break;
			}
			case R.id.btn_close_br: {
				etWorkSpace.setText(etWorkSpace.getText() + ")");
				break;
			}
			case R.id.btn_add: {
				etWorkSpace.setText(etWorkSpace.getText() + "+");
				break;
			}
			case R.id.btn_minus: {
				etWorkSpace.setText(etWorkSpace.getText() + "-");
				break;
			}
			case R.id.btn_division : {
				etWorkSpace.setText(etWorkSpace.getText() + "/");
				break;
			}
			case R.id.btn_mul: {
				etWorkSpace.setText(etWorkSpace.getText() + "*");
				break;
			}
			case R.id.btn_equals: {
				doCalculateLib(etWorkSpace.getText().toString());
				break;
			}
			case R.id.btn_correction: {
				if (
					(etWorkSpace.getText().toString().indexOf("\uD835\uDED1") != -1 &&
					etWorkSpace.getText().toString().indexOf("\uD835\uDED1") == etWorkSpace.getText().toString().length() - 2) ||
					(etWorkSpace.getText().toString().indexOf("\uD835\uDC1E") != -1 &&
					etWorkSpace.getText().toString().indexOf("\uD835\uDC1E") == etWorkSpace.getText().toString().length() - 2)
				) {
					etWorkSpace.setText(etWorkSpace.getText().toString().substring(0, etWorkSpace.getText().toString().length() - 2));
				} else {
					etWorkSpace.setText(etWorkSpace.getText().toString().substring(0, etWorkSpace.getText().toString().length() - 1));
				}
				break;
			}
			case R.id.btn_clear: {
				etWorkSpace.setText("");
				break;
			}
			case R.id.btn_pi: {
				etWorkSpace.setText(etWorkSpace.getText() + "\uD835\uDED1");
				break;
			}
			case R.id.btn_exp: {
				etWorkSpace.setText(etWorkSpace.getText() + "\uD835\uDC1E");
				break;
			}

			case R.id.btn_percentage: {
				etWorkSpace.setText(etWorkSpace.getText() + "%");
				break;
			}
		}
	}

	private void doCalculateLib(String str) {
		ArrayList<Character> allowedOperation = new ArrayList<Character> () {{ add('+'); add('-'); add('*'); add('/'); add('('); add(')');}};
		char[] charArray = str.toCharArray();
		if (str.isEmpty() || allowedOperation.contains(charArray[charArray.length - 1])) {
			if (str.isEmpty()) etResult.setText("");
			return;
		}
		if (str.contains("(") && !str.contains(")")) {
			str += ")";
		}
		if (str.contains("\uD835\uDED1")) {
			str = str.replace("\uD835\uDED1", "3.14159265359");
		}
		if (str.contains("\uD835\uDC1E")) {
			str = str.replace("\uD835\uDC1E", "2.71828182846");
		}
		if (str.contains("%")) {
			str = str.replace("%", "/100");
		}

		BigDecimal result = null;
		Log.d(TAG,"string test = " + str);
		Expression expression = new Expression(str);
		try {
			result = expression.eval();
			expression.setPrecision(2);
		} catch (Exception ex) {
			Snackbar.make(getView(), ex.getMessage(), Snackbar.LENGTH_SHORT).show();
			etResult.setText(ex.getMessage());
			return;
		}
		etResult.setText("" + result);
	}
}