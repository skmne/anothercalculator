package com.madnessofcorner.anothercalculator.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.madnessofcorner.anothercalculator.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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

	private Operaion lastOpertion = Operaion.EQUALS;
	private ArrayList<OperationWrapper> historyOperation = new ArrayList<>();

	public View onCreateView(@NonNull LayoutInflater inflater,
							 ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_home, container, false);
		etWorkSpace = root.findViewById(R.id.et_workspace);
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
			case R.id.btn_add: {
				doFillHistoryOperation(etWorkSpace.getText().toString());
				lastOpertion = Operaion.ADD;
				etWorkSpace.setText(etWorkSpace.getText() + " + ");
				break;
			}
			case R.id.btn_minus: {
				doFillHistoryOperation(etWorkSpace.getText().toString());
				lastOpertion = Operaion.MINUS;
				etWorkSpace.setText(etWorkSpace.getText() + " - ");
				break;
			}
			case R.id.btn_division : {
				doFillHistoryOperation(etWorkSpace.getText().toString());
				lastOpertion = Operaion.DIVISION;
				etWorkSpace.setText(etWorkSpace.getText() + " / ");
				break;
			}
			case R.id.btn_mul: {
				doFillHistoryOperation(etWorkSpace.getText().toString());
				lastOpertion = Operaion.MULTIPLICATION;
				etWorkSpace.setText(etWorkSpace.getText() + " * ");
				break;
			}
			case R.id.btn_equals: {
				doFillHistoryOperation(etWorkSpace.getText().toString());
				lastOpertion = Operaion.EQUALS;
				doCalculate(etWorkSpace.getText().toString());
				break;
			}
			case R.id.btn_correction: {
				historyOperation.clear();
				etWorkSpace.setText("");
				break;
			}
			case R.id.btn_clear: {
				historyOperation.clear();
				etWorkSpace.setText("");
				break;
			}
		}
	}

	enum Operaion{
		ADD,
		MINUS,
		EQUALS,
		MULTIPLICATION,
		DIVISION
	}
	public class OperationWrapper {
		Operaion op;
		Float value;
		public OperationWrapper(Operaion op, Float value){
			this.op = op;
			this.value = value;
		}
		@Override
		public String toString(){ //for debug!
			return "Operation = " + this.op + " Value = " + this.value;
		}
	}
	private String doCalculate(String str) {
		if (str.contains("+")) {
			//first do priority operation
			String[] test = str.split("\\+");
			Log.d(TAG, "tes = " + Arrays.toString(test));
		}
		if (str.contains("*")) {
		}

		Float buffer = 0.0f;
		if (historyOperation.get(0).op == Operaion.EQUALS) {
			buffer = historyOperation.get(0).value;
		}

		for (int i = 0; i < historyOperation.size(); i++) {
			if (
					historyOperation.get(i).op == Operaion.MULTIPLICATION &&
					historyOperation.get(i - 1).op != Operaion.MULTIPLICATION &&
					historyOperation.get(i - 1).op != Operaion.DIVISION &&
					historyOperation.get(i - 1).op != Operaion.EQUALS
			) {
				historyOperation.get(i - 1).value = historyOperation.get(i - 1).value * historyOperation.get(i).value;
			} else if (
					historyOperation.get(i).op == Operaion.DIVISION &&
					historyOperation.get(i - 1).op != Operaion.MULTIPLICATION &&
					historyOperation.get(i - 1).op != Operaion.DIVISION &&
					historyOperation.get(i - 1).op != Operaion.EQUALS
			) {
				historyOperation.get(i - 1).value = historyOperation.get(i - 1).value / historyOperation.get(i).value;
			} else {
				if (historyOperation.get(i).op == Operaion.MULTIPLICATION) {
					buffer *= historyOperation.get(i).value;
				}
				if (historyOperation.get(i).op == Operaion.DIVISION) {
					buffer = buffer / historyOperation.get(i).value;
				}
			}
		}
		for (OperationWrapper item: historyOperation) {
			if (item.op == Operaion.ADD) {
				buffer += item.value;
			}
			if (item.op == Operaion.MINUS) {
				buffer -= item.value;
			}
		}

		etResult.setText("" + buffer);
		return "";
	}

	private void doFillHistoryOperation(final String str) {

		HashMap<Operaion, String> hashMap = new HashMap<Operaion, String> ();
		hashMap.put(
				lastOpertion,
				str.contains(" ") ? str.substring(str.lastIndexOf(" "), str.length()) : str
		);
		historyOperation.add(new OperationWrapper(
			lastOpertion,
			str.contains(" ") ? Float.parseFloat(str.substring(str.lastIndexOf(" "), str.length())) : Float.parseFloat(str)
		));
		Log.d(TAG,  "buffer = " + historyOperation.toString());
	}
}