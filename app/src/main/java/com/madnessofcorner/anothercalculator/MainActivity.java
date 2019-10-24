package com.madnessofcorner.anothercalculator;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.google.android.material.snackbar.Snackbar;
import com.udojava.evalex.Expression;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	private static final String TAG = "MAIN_SCREEN";
	private static final int LIMIT_HISTRY_STORAGE = 20;

	private EditText etWorkSpace;
	private TextView etResult;

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
	private Button btnFact;
	private Button btnLog;
	private Button btnSquareRoot;
	private Button btnSquare;

	private Button btnDeg;
	private Button btnSin;
	private Button btnCos;
	private Button btnTan;
	private Button btnRad;

	private TextView tvHistory;
	private final String[] deletedOperation = {"COS(", "SIN(", "FACT(", "LOG(", "RAD(", "DEG(", "PI", "SQRT(", "TAN("};
	private final String[] operationsForReplace = {
            "+", "-", "*", "/", "^", "."
	};
    ArrayList<Character> allowedOperation = new ArrayList<Character> () {{ add('+'); add('-'); add('*'); add('/'); add('('); add(')'); add('^');}};

	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etWorkSpace = findViewById(R.id.et_workspace);
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
		etResult = findViewById(R.id.tv_result);

		btn0 = findViewById(R.id.button0);
		btn1 = findViewById(R.id.button1);
		btn2 = findViewById(R.id.button2);
		btn3 = findViewById(R.id.button3);
		btn4 = findViewById(R.id.button4);
		btn5 = findViewById(R.id.button5);
		btn6 = findViewById(R.id.button6);
		btn7 = findViewById(R.id.button7);
		btn8 = findViewById(R.id.button8);
		btn9 = findViewById(R.id.button9);

		btnDot = findViewById(R.id.btn_dot);
		btnAdd = findViewById(R.id.btn_add);
		btnMinus = findViewById(R.id.btn_minus);
		btnMul = findViewById(R.id.btn_mul);
		btnDiv = findViewById(R.id.btn_division);
		btnEquals = findViewById(R.id.btn_equals);
		btnClear = findViewById(R.id.btn_clear);

		btnOpenBr = findViewById(R.id.btn_open_br);
		btnCloseBr = findViewById(R.id.btn_close_br);

		btnCorrection = findViewById(R.id.btn_correction);

		btnPi = findViewById(R.id.btn_pi);
		btnExp = findViewById(R.id.btn_exp);
		btnPercentage = findViewById(R.id.btn_percentage);
		btnFact = findViewById(R.id.btn_fact);
		btnLog = findViewById(R.id.btn_log);
		btnSquareRoot = findViewById(R.id.btn_square_root);
		btnSquare = findViewById(R.id.btn_square);

		btnDeg = findViewById(R.id.btn_deg);
		btnSin = findViewById(R.id.btn_sin);
		btnCos = findViewById(R.id.btn_cos);
		btnTan = findViewById(R.id.btn_tan);
		btnRad = findViewById(R.id.btn_rad);

		tvHistory = findViewById(R.id.tv_history);
		tvHistory.setText(getHistory());
        tvHistory.setMovementMethod(new ScrollingMovementMethod());
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
		btnFact.setOnClickListener(this);
		btnLog.setOnClickListener(this);
		btnSquare.setOnClickListener(this);
		btnSquare.setOnClickListener(this);

		btnDeg.setOnClickListener(this);
		btnSin.setOnClickListener(this);
		btnCos.setOnClickListener(this);
		btnTan.setOnClickListener(this);
		btnRad.setOnClickListener(this);
		if (savedInstanceState != null) {
			etResult.setText(savedInstanceState.getString("result"));
		}
	}

	@Override
	public void onClick(View view) {
        // Get instance of Vibrator from current Context
        Vibrator v = (Vibrator) getSystemService(this.VIBRATOR_SERVICE);
        v.vibrate(50);
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
				doSaveHistory();
				etWorkSpace.setText(etResult.getText());
				break;
			}
			case R.id.btn_correction: {
				if (etWorkSpace.getText().toString().isEmpty()) {
					break;
				}
				boolean isLastOperation = false;
				for (String operation: deletedOperation) {
					if (
							etWorkSpace.getText().toString().indexOf(operation) != -1 &&
									etWorkSpace.getText().toString().indexOf(operation) == (etWorkSpace.getText().toString().length() - operation.length())
					) {
						etWorkSpace.setText(etWorkSpace.getText().toString().substring(0, etWorkSpace.getText().toString().length() - operation.length()));
						isLastOperation = true;
						break;
					}
				}

				if (!isLastOperation) {
					etWorkSpace.setText(etWorkSpace.getText().toString().substring(0, etWorkSpace.getText().toString().length() - 1));
				}
				break;
			}
			case R.id.btn_clear: {
				etWorkSpace.setText("");
				break;
			}
			case R.id.btn_pi: {
				etWorkSpace.setText(etWorkSpace.getText() + "PI");
				break;
			}
			case R.id.btn_exp: {
				etWorkSpace.setText(etWorkSpace.getText() + "e");
				break;
			}

			case R.id.btn_percentage: {
				etWorkSpace.setText(etWorkSpace.getText() + "%");
				break;
			}
			case R.id.btn_fact: {
				etWorkSpace.setText(etWorkSpace.getText() + "FACT(");
				break;
			}
			case R.id.btn_log: {
				etWorkSpace.setText(etWorkSpace.getText() + "LOG(");
				break;
			}
			case R.id.btn_square_root: {
				etWorkSpace.setText(etWorkSpace.getText() + "SQRT(");
				break;
			}
			case R.id.btn_square: {
				etWorkSpace.setText(etWorkSpace.getText() + "^");
				break;
			}

			case R.id.btn_sin: {
				etWorkSpace.setText(etWorkSpace.getText() + "SIN(");
				break;
			}
			case R.id.btn_cos: {
				etWorkSpace.setText(etWorkSpace.getText() + "COS(");
				break;
			}
			case R.id.btn_tan: {
				etWorkSpace.setText(etWorkSpace.getText() + "TAN(");
				break;
			}
			case R.id.btn_rad: {
				etWorkSpace.setText(etWorkSpace.getText() + "RAD(");
				break;
			}
			case R.id.btn_deg: {
				etWorkSpace.setText(etWorkSpace.getText() + "DEG(");
				break;
			}
		}
	}

	@Override
	public void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString("result", etResult.getText().toString());
	}

	private void doSaveHistory() {
		String historyItem = etWorkSpace.getText() + " = " + etResult.getText() + "\n";

		if (tvHistory.getLineCount() > LIMIT_HISTRY_STORAGE) {
		    String[] tempArray = tvHistory.getText().toString().split("\n");
		    String tempString = "";
		    for(int i = 1; i < LIMIT_HISTRY_STORAGE; i++){
                tempString += tempArray[i] + "\n";
            }
            tvHistory.setText(tempString + historyItem);
        } else {
            tvHistory.setText(tvHistory.getText() + historyItem);
        }
		SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
		SharedPreferences.Editor prefEdit = prefs.edit();
		prefEdit.putString("history", tvHistory.getText().toString());
		prefEdit.commit();
	}

	private String getHistory() {
		SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
		return prefs.getString("history", "");
	}

	private void doCalculateLib(String str) {

		char[] charArray = str.toCharArray();
        for (String operation: operationsForReplace) {
            if (
                    str.lastIndexOf(operation) != -1 && str.lastIndexOf(operation) == (str.length() - operation.length())
            ) {
                for (String operation2: operationsForReplace){
                    if (str.substring(0, str.lastIndexOf(operation)).indexOf(operation2) != -1 &&
                            str.substring(0, str.lastIndexOf(operation)).indexOf(operation2)  == (str.substring(0, str.lastIndexOf(operation)).length() - operation2.length())
                    ) {
                        if (operation2.equals(operation)) {
                            str = str.substring(0, str.lastIndexOf(operation));
                            etWorkSpace.setText(str);
                        } else {
                            String newOperation = str.substring(str.lastIndexOf(operation));
                            str = str.substring(0, str.lastIndexOf(operation2)) + newOperation;
                            etWorkSpace.setText(str);
                        }
                        break;
                    }
                }
                break;
            }
        }
		if (str.isEmpty() || allowedOperation.contains(charArray[charArray.length - 1])) {
			if (str.isEmpty()) etResult.setText("");
			return;
		}
		if (str.contains("(") && !str.contains(")")) {
			str += ")";
		}
		if (str.contains("%")) {
			str = str.replace("%", "/100");
		}
		BigDecimal result = null;
		Expression expression = new Expression(str);
		try {
			result = expression.eval();
			expression.setPrecision(2);
		} catch (Exception ex) {
			Snackbar.make(etResult, ex.getMessage(), Snackbar.LENGTH_SHORT).show();
			etResult.setText(ex.getMessage());
			return;
		}
		etResult.setText(result.toEngineeringString());
	}
}
