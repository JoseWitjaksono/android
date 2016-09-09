package id.sch.smktelkom_mlg.xirpl6034.pengumpulantugas;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	EditText etNama;
	RadioGroup rgStatus;
	Button bOK;
	TextView tvHasil;
	CheckBox cbUlangan;
	CheckBox cbTugas;
	CheckBox cbLatihan;
	Spinner spGuru;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etNama = (EditText) findViewById(R.id.editTextNama);
		bOK = (Button) findViewById(R.id.buttonOK);
		tvHasil = (TextView) findViewById(R.id.textViewHasil);
		rgStatus = (RadioGroup) findViewById(R.id.radioGroupStatus);
		cbUlangan = (CheckBox) findViewById(R.id.checkBox1);
		cbTugas = (CheckBox) findViewById(R.id.checkBox2);
		cbLatihan = (CheckBox) findViewById(R.id.checkBox3);
		spGuru = (Spinner) findViewById(R.id.spinnerGuru);

		bOK.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				doClick();
			}

			private void doClick() {
				String hasil = null;
				String tugas = "";
				String tugas2 = "";
				String tugas3 = "";

				String nama = etNama.getText().toString();
				if (cbUlangan.isChecked()) {
					tugas = cbUlangan.getText().toString();
				}
				if (cbTugas.isChecked()) {
					tugas2 = "," + cbTugas.getText().toString();
				}
				if (cbLatihan.isChecked()) {
					tugas3 = "," + cbLatihan.getText().toString() + " ";
				}
				if (rgStatus.getCheckedRadioButtonId() != -1) {
					RadioButton rb = (RadioButton)
							findViewById(rgStatus.getCheckedRadioButtonId());
					hasil = rb.getText().toString();
					tvHasil.setText(nama + " " + hasil + " Mengumpulkan " + tugas + " " + tugas2 + " " + tugas3 + "Kepada " + spGuru.getSelectedItem().toString());
				}
			}
		});
	}
}
