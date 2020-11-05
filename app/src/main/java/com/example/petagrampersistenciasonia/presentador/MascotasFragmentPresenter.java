package com.example.petagrampersistenciasonia.presentador;

import android.content.Context;

import com.rosana.petagrampersistencia.classes.Mascota;
import com.rosana.petagrampersistencia.db.ConstructorMascotas;
import com.rosana.petagrampersistencia.fragments.IMascotasFragmentView;

import java.util.ArrayList;

public class MascotasFragmentPresenter implements IMascotasFragmentPresenter {

    private IMascotasFragmentView iMascotasFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public MascotasFragmentPresenter(IMascotasFragmentView iMascotasFragmentView, Context context) {
        this.iMascotasFragmentView = iMascotasFragmentView;
        this.context = context;
    }

    @Override
    public void obtenerMascotasBD() {
        constructorMascotas = new ConstructorMascotas( context );
        mascotas =  constructorMascotas.getMascotas();
        mostrarMascotas();
    }

    @Override
    public void mostrarMascotas() {
        iMascotasFragmentView.initAdaptadorRV( iMascotasFragmentView.generateMascotaAdaptador( mascotas ) );
        iMascotasFragmentView.generateLinearLayot();
    }
}
