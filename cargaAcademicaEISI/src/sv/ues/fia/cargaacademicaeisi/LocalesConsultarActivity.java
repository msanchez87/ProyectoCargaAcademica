package sv.ues.fia.cargaacademicaeisi;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class LocalesConsultarActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_locales_consultar);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.locales_consultar, menu);
		return true;
	}

}
