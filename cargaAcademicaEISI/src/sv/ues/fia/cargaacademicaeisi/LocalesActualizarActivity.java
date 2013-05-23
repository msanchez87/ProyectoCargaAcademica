package sv.ues.fia.cargaacademicaeisi;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class LocalesActualizarActivity extends Activity implements OnItemSelectedListener{

	private ControlDB helper;
	private EditText CapLocales;
	private Spinner spnListaLocales;
	private List<String> idLocales;
	private ArrayAdapter<String> adapter;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_locales_actualizar);
		
		helper = new ControlDB(this);
		CapLocales = (EditText) findViewById(R.id.capacidadLocal);
		spnListaLocales = (Spinner) findViewById(R.id.spn_Select_Local);

		helper.abrir();
		idLocales = helper.getAll_IdLocales();
		helper.cerrar();
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, idLocales);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spnListaLocales.setAdapter(adapter);
		spnListaLocales.setOnItemSelectedListener(this);
	}
	
	public void actualizarLocal(View v) {
		if (!CapLocales.getText().toString().trim().equals("")) {
			Locales local = new Locales();
			local.setIdlocal(spnListaLocales.getSelectedItem().toString());
			local.setCapacidad(CapLocales.getText().toString());
			helper.abrir();
			String estado = helper.actualizar(local);
			helper.cerrar();
			Toast.makeText(this, estado, Toast.LENGTH_LONG).show();
		} else {
			CapLocales.setText("");
			Toast.makeText(this, "Asignar capacidad es obligatorio",
					Toast.LENGTH_LONG).show();
		}

	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
		// TODO Auto-generated method stub
		String idLocal = arg0.getItemAtPosition(arg2).toString();
		Locales local = new Locales();
		helper.abrir();		
		local = helper.consultarLocal(idLocal);
		helper.cerrar();
		CapLocales.setText(local.getCapacidad());		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
