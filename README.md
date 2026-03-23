Taller a desarrollar:
PUNTO PRÁCTICO PRIMER PARCIAL ANDROID 202601
Objetivo:
•	Creación y navegación entre dos Activities (Intent explícito con extras).
•	Uso de TextView, EditText, Button, ImageView.
•	Manejo de eventos con OnClickListener 
•	Validación de entradas numéricas.
•	Actualización dinámica de un ImageView según la operación realizada.
Enunciado para el estudiante
Desarrolla una app con dos Activities:
Pantalla 1 – Operador Avanzado
UI requerida:
•	Dos EditText para Número A y Número B (decimales permitidos).
•	Buttons: Potencia, Módulo, Máximo, Limpiar, Ver detalle.
•	TextView para Resultado (mostrar el valor calculado).
•	ImageView que cambia según la operación: 
o	Potencia → ícono de rayo/exp
o	Módulo → ícono “%”
o	Máximo → ícono “↑” o “max”
Comportamiento:
•	Potencia calcula A^B 
•	Módulo calcula A % B (valida que B ≠ 0).
•	Máximo muestra max(A, B).
•	Limpiar borra inputs, resultado e ícono.
•	Ver detalle abre Pantalla 2 con Intent explícito, enviando por extras: 
o	Operación, de acuerdo a la operación seleccionada. {"POTENCIA","MODULO","MAXIMO"}
o	a, b (Double)
o	resultado (Double)



Pantalla 2 – Detalle
UI requerida:
•	TextViews para: operación, A, B y resultado (recibidos por Intent).
•	ImageView con ícono acorde a la operación.
•	Button: Regresar (cierra con finish()).
Comportamiento:
•	Muestra los datos con formato.
•	Ícono según operación.
•	Botón Regresar vuelve a la pantalla anterior.
