package com.example.money;

import android.support.v7.app.ActionBarActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private EditText et_monto, et_fecha, et_motivo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		et_monto = (EditText)findViewById(R.id.eTextMonto);
		et_fecha = (EditText)findViewById(R.id.eTextFecha);
		et_motivo = (EditText)findViewById(R.id.eTextMotivo);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void cargar(View view){
		AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "money", null, 1);
		SQLiteDatabase db = admin.getWritableDatabase();
		
		int monto = Integer.parseInt(et_monto.getText().toString());
		String fecha = et_fecha.getText().toString();
		String motivo = et_motivo.getText().toString();
		
		ContentValues registro = new ContentValues();
		
		registro.put("monto", monto);
		registro.put("fecha", fecha);
		registro.put("info", motivo);
		
		db.insert("gastos", null, registro);
		db.close();
		et_monto.setText("");
		et_fecha.setText("");
		et_motivo.setText("");
		
		Toast.makeText(this, "Se cargaron los datos en la base de datos", Toast.LENGTH_SHORT).show();
	}
	
	public void lanzar(View view){
		Intent i = new Intent(this,Listado.class);
		startActivity(i);
	}
}
