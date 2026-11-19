# Enunciado: Cola de impresión compartida (TDA Cola FIFO)

## Contexto

Una oficina dispone de una **única impresora compartida**. Los usuarios envían
**trabajos de impresión** que se atienden **en estricto orden de llegada**
(el primero que llega es el primero que se imprime).

## Requisitos

- Cada trabajo registra: **id** único, **usuario**, nombre del **documento** y
  número de **páginas**.
- Operaciones:
  - `enviar(trabajo)`: añade el trabajo **al final** de la cola.
  - `imprimirSiguiente()`: atiende (desencola) el trabajo más antiguo.
  - `verSiguiente()`: muestra cuál se imprimirá sin quitarlo.
  - `cancelar(id)`: retira un trabajo pendiente.
  - `pendientes()`: lista los trabajos en orden y el total de páginas en espera.
- Si la cola está vacía, `imprimirSiguiente`/`verSiguiente` devuelven `null`.


## Simulación esperada

Enviar 3 trabajos, imprimir los dos primeros, cancelar uno, estado de la cola, mostrar pendientes, resetear la cola (borrar).
