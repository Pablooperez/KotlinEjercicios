# Enunciado: Sistema de pedidos de pizza "Dominos Pizza"

## Contexto

Se desea desarrollar una aplicación de consola que simule el proceso de
**realizar un pedido "para llevar"** en la pizzería **Dominos Pizza**. El cliente
interactúa con el programa a través de **menús auxiliares** que le guían en la
selección de las pizzas, su personalización y la forma de entrega.

## Requisitos

### 1. Inicio del pedido

- Mostrar un **mensaje de bienvenida** a Dominos Pizza.
- Preguntar al usuario la **cantidad de pizzas** que desea pedir.
- El cliente puede **salir del proceso en cualquier momento**, cancelando el
  pedido.

### 2. Selección de cada pizza

Para cada pizza del pedido se muestra un **menú auxiliar** con las siguientes
opciones:

| #  | Pizza                 | Ingredientes                                                                          |
|----|-----------------------|---------------------------------------------------------------------------------------|
| 1  | Americana             | Salsa de tomate, mozzarella, extra de pepperoni, bacon y cebolla roja                   |
| 2  | Barbacoa              | Salsa barbacoa, carne, cebolla roja y bacon, extra de queso                             |
| 3  | Carbonara             | Salsa carbonara, jamón de York, champiñones, cebolla roja, extra de queso               |
| 4  | Hawaiana              | Doble jamón, doble de piña, extra de mozzarella, salsa carbonara, extra de queso        |
| 5  | Meat Lovers           | Salsa de tomate, carne, pepperoni, jamón de York, bacon y mozzarella                    |
| 6  | Por Mitades           | 2 mitades, cada una de una pizza pre-elaborada (opciones 1 a 5)                         |
| 7  | Crea Tu Propia Pizza  | Al gusto del usuario                                                                    |

- **Por Mitades**: el cliente elige **dos** pizzas pre-elaboradas (1-5), una
  para cada mitad.
- **Crea Tu Propia Pizza**: el cliente parte de una pizza pre-elaborada y le
  **añade ingredientes a su gusto**. Cada ingrediente extra tiene un **precio**
  que se suma al precio base de la pizza elegida.

### 3. Personalización de cada pizza

Para cada pizza seleccionada el cliente debe elegir:

- **Tipo de masa**: `Masa Tradicional`, `Masa Fina`, `Masa Rolling`,
  `Masa Rolling con queso`.
- **Tamaño**: `pequeña`, `mediana` o `familiar`.

### 4. Tipo de pedido

- El cliente selecciona el tipo de pedido: `local`, `a domicilio` o `recoger`.
- Las **promociones están vinculadas al tipo de pedido**. Si existe alguna
  promoción aplicable, se aplica **al final del pedido** sobre el total.

### 5. Resumen y confirmación

- Antes de finalizar, se muestra al cliente un **resumen completo del pedido**:
  cada pizza con sus ingredientes, mitades o extras, masa, tamaño y precio,
  además del tipo de pedido, la promoción aplicada y el **importe total**.
- El cliente puede **confirmar** el pedido o **modificarlo**:
  - **Añadir** una nueva pizza.
  - **Eliminar** una pizza existente.
  - **Modificar** una pizza (tipo, ingredientes, masa o tamaño).
- Tras cada modificación se vuelve a mostrar el resumen actualizado.

## Diseño esperado

Identificar las clases, enumerados y relaciones necesarias para modelar el
problema. Como mínimo se espera:

- Clases para: **Pizza**, **Ingrediente**, **Pedido**, **Promoción** y el
  **gestor/menú** que conduce el proceso de compra.
- Enumerados para: **tipo de masa**, **tamaño** y **tipo de pedido**.
- Gestión de precios: precio base por pizza y tamaño, recargo por ingredientes
  extra y descuento por promoción.
- Una **simulación** en `main` que muestre el flujo completo: bienvenida,
  selección de varias pizzas (incluyendo una por mitades y una personalizada),
  elección de masa y tamaño, tipo de pedido con promoción, resumen,
  modificación del pedido y confirmación final.
