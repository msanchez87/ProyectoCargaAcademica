package sv.ues.fia.cargaacademicaeisi;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class EliminarMateriasImpartirActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eliminar_materias_impartir);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.eliminar_materias_impartir, menu);
		return true;
	}

}