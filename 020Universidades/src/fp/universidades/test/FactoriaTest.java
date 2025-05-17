package fp.universidades.test;

import java.util.List;

import fp.universidades.tipos.Alumno;
import fp.universidades.tipos.Espacio;
import fp.universidades.tipos.FactoriaUniversidad;
import fp.universidades.tipos.Nota;

public class FactoriaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Al crear la variable planta como una derivada del nombre hay errores en las plantas de las salas cuyos nombres no siguen el formato AX.XX
		List<Espacio> Espacios = FactoriaUniversidad.leeEspacios("C:\\Users\\ale\\Documents\\202-EclipseWorkspace\\Universidades\\data\\espacios.csv");
		System.out.println(Espacios);
		Espacio e0 = Espacios.get(0);
		
		System.out.println(e0.getNombre());
		
		List<Alumno> Alumnos = FactoriaUniversidad.leeAlumnos("C:\\Users\\ale\\Documents\\202-EclipseWorkspace\\Universidades\\data\\alumnos.csv");
		System.out.println(Alumnos);
		Alumno a0 = Alumnos.get(0);
		
		System.out.println(a0.getDNI());

		List<Nota> Notas = FactoriaUniversidad.leeNotas("C:\\Users\\ale\\Documents\\202-EclipseWorkspace\\Universidades\\data\\notas.csv");
		System.out.println(Notas);
		Nota n0 = Notas.get(0);
		
		System.out.println(n0.Asignatura());
		System.out.println(n0.Valor());
	}

}
