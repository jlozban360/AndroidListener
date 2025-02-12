package es.iesoretania.listener;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import es.iesoretania.listener.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding = ActivityMainBinding.inflate( getLayoutInflater( ) );
        setContentView( binding.getRoot( ) );

        binding.button.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick( View view ) {

                int valor1 = Integer.parseInt( binding.editTextNumber.getText( ).toString( ) );
                int valor2 = Integer.parseInt( binding.editTextNumber2.getText( ).toString( ) );
                int valor3 = Integer.parseInt( binding.editTextNumber3.getText( ).toString( ) );

                int calc = ( valor1 + valor2 + valor3 ) / 3;

                String strFinal;
                if( calc >= 5 )
                    strFinal = "Aprobado con " + calc + " de media (List)";
                else
                    strFinal = "Suspenso con " + calc + " de media (List)";

                binding.textView.setText( strFinal );
            }
        });
    }
}