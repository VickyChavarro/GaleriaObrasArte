import java.util.*;

public class PantallaGaleria {
    public static void main(String[] args) {

        ArrayList<Obra> listaObras = new ArrayList<>();
        ArrayList<Artista> listaArtistas = new ArrayList<>();
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        Map<Compra, Long> mapaCompras = new HashMap<>();
        ArrayList<Compra> listaCompras = new ArrayList<>();

        Scanner sn = new Scanner(System.in);
        int criterio = 0;
        int codigoCompra = 0;
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        ControlGaleria control1 = new ControlGaleria(listaObras, listaArtistas, listaClientes);

        System.out.println("1. Ver listado obras disponibles");
        System.out.println("2. Buscar una obra por título, artista o año");
        System.out.println("3. Insertar una obra");
        System.out.println("4. Modificar una obra");
        System.out.println("5. Eliminar una obra");
        System.out.println("6. Ver listado de clientes registrados en el sistema");
        System.out.println("7. Buscar un cliente");
        System.out.println("8. Insertar cliente");
        System.out.println("9. Modificar datos de cliente");
        System.out.println("10. Eliminar un cliente");
        System.out.println("11. Realizar compra de una obra");
        System.out.println("12. Eliminar compra de obra");
        System.out.println("13. Ver listado de compras existentes");
        System.out.println("14. Ver listado de compras para un mes y año especifico insertado por el usuario");
        System.out.println("15. Ver listado de artistas mas vendidos");
        System.out.println("16. Salir");
        do {
            try {
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        ControlGaleria.imprimirObras(listaObras);
                        break;
                    case 2:
                        buscarPorCriterio(criterio, listaObras, listaArtistas);
                        break;
                    case 3:
                        insertarObra(criterio, listaObras, listaArtistas);
                        break;
                    case 4:
                        modificarObra(listaObras);
                        break;
                    case 5:
                        eliminarObra(listaObras);
                        break;
                    case 6:
                        ControlGaleria.imprimirClientes(listaClientes);
                        break;
                    case 7:
                        buscarCliente(listaClientes);
                        break;
                    case 8:
                        insertarCliente(listaClientes);
                        break;
                    case 9:
                        modificarCliente(listaClientes);
                        break;
                    case 10:
                        eliminarCliente(listaClientes);
                        break;
                    case 11:
                        //realizarCompra(mapaCompras, listaClientes, listaObras, listaCompras, codigoCompra);
                        System.out.println(listaCompras);
                        break;
                    case 12:
                        System.out.println("Has seleccionado la opción 12");
                        break;
                    case 13:
                        //comprasExistentes(mapaCompras, listaObras, listaClientes);
                        break;
                    case 14:
                        System.out.println("Has seleccionado la opción 14");
                        break;
                    case 15:
                        System.out.println("Has seleccionado la opción 15");
                        break;
                    case 16:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 16");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }

            ///***
        }
        while (!salir);
    }

    public static void buscarPorCriterio(int criterio, ArrayList<Obra> listaObras, ArrayList<Artista> listaArtistas) {
        Scanner sc = new Scanner(System.in);
        Scanner scCriterio = new Scanner(System.in);
        try {
            System.out.println("Ingrese el criterio por el que desea buscar");
            System.out.println("0. Titulo");
            System.out.println("1. Artista");
            criterio = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Debes insertar un número");
            sc.next();
        }

        if (criterio == 0) {
            System.out.println("Ingrese el titulo de la obra que quiere buscar: ");
            String tituloAux = scCriterio.nextLine();
            Obra obraAux = ControlGaleria.buscarTitulo(listaObras, tituloAux);
            if (obraAux == null) {
                System.out.println("No existe obra de tal titulo disponible por el momento");
            } else {
                System.out.println(obraAux + "\n");
            }
        } else if (criterio == 1) {
            System.out.println("Ingrese el titulo de la obra que quiere buscar: ");
            String nombreAux = scCriterio.nextLine();
            Artista artistaAux = ControlGaleria.buscarArtista(listaArtistas, nombreAux);
            if (artistaAux == null) {
                System.out.println("No existe tal artista asociado a alguna obra por el momento");
            } else {
                System.out.println(artistaAux + "\n");
            }
        }
    }

    public static void buscarCliente(ArrayList<Cliente> listaClientes) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cedula del cliente que quiere buscar:");
        long cedulaAux = sc.nextLong();
        Cliente clienteAux = ControlGaleria.buscarCliente(listaClientes, cedulaAux);
        if (clienteAux == null) {
            System.out.println("No existe el cliente asociado a nuestro sistema");
        } else {
            System.out.println(clienteAux + "\n");
        }
    }

    public static void insertarCliente(ArrayList<Cliente> listaClientes) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Ingrese el codigo del cliente a insertar: ");
            long codigoAux = sc.nextLong();
            for (Cliente cliente : listaClientes) {
                if (cliente.getCodigoCliente() == codigoAux) {
                    throw new Exception("ERROR - El codigo ya existe");
                }
            }
            System.out.println("Ingrese la cedula del cliente a insertar: ");
            long cedulaAux = sc.nextLong();
            for (Cliente cliente : listaClientes) {
                if (cedulaAux == cliente.getCedula()) {
                    throw new Exception("ERROR- Ya existe esta cedula en el sistema");
                } else if (cedulaAux < 0) {
                    throw new Exception("ERROR - Cedula negativa");
                }
            }
            System.out.println("Ingrese el nombre del cliente a insertar ");
            String nombreAux = sc.next();
            System.out.println("Ingrese los apellidos del cliente a insertar: ");
            String apellidosAux = sc.next();
            sc.nextLine();
            System.out.println("Ingrese la direccion de entrega del cliente a insertar ");
            String direccionAux = sc.nextLine();
            System.out.println("Ingrese el telefono del cliente a insertar: ");
            long telefonoAux = sc.nextLong();
            Cliente clienteNuevo = new Cliente(codigoAux, cedulaAux, nombreAux, apellidosAux, direccionAux, telefonoAux);
            listaClientes.add(clienteNuevo);
            System.out.println("Cliente insertado con exito!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertarObra(int criterio, ArrayList<Obra> listaObras, ArrayList<Artista> listaArtistas) {
        Scanner sc = new Scanner(System.in);
        Scanner scInfo = new Scanner(System.in);
        try {
            System.out.println("Ingrese que desea añadir");
            System.out.println("0. Obra");
            System.out.println("1. Artista");
            criterio = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Debes insertar un número");
            sc.next();
        }

        if (criterio == 0) {
            try {
                System.out.println("Ingrese el codigo de la obra a insertar: ");
                String codigoAux = scInfo.nextLine();
                for (Obra obra : listaObras) {
                    if (obra.getCodigoObra() == Long.parseLong(codigoAux)) {
                        throw new Exception("ERROR - El codigo ya existe");
                    }
                }
                if (Long.parseLong(codigoAux) < 0) {
                    throw new Exception("ERROR - Codigo negativo");
                } else if (codigoAux.length() != 7) {
                    throw new Exception("ERROR - Codigo mayor a 7 digitos");
                }
                //Long.parseLong(codigoAux);
                System.out.println("Ingrese el titulo de la obra a insertar: ");
                String tituloAux = scInfo.nextLine();
                System.out.println("Ingrese el precio de referencia de la obra a insertar: ");
                float precioAux = scInfo.nextFloat();
                System.out.println("Ingrese las dimensiones de la obra a insertar (LargoxAncho): ");
                String dimensionesAux = scInfo.next();
                Obra obraNueva = new Obra(Long.parseLong(codigoAux), tituloAux, precioAux, dimensionesAux);
                listaObras.add(obraNueva);
                System.out.println("Obra insertada con exito!");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if (criterio == 1) {

            try {
                System.out.println("Los artistas existentes en el sistema son:");
                ControlGaleria.imprimirArtistas(listaArtistas);
                System.out.println("Ingrese la cedula del artista: ");
                long cedulaAux = scInfo.nextLong();
                for (Artista artista : listaArtistas) {
                    if (artista.getCedula() == cedulaAux) {
                        throw new Exception("ERROR - El artista ya esta en el sistema");
                    }
                }
                System.out.println("Ingrese el nombre del artista: ");
                String nombreAux = scInfo.next();
                System.out.println("Ingrese el apellido del artista: ");
                String apellidoAux = scInfo.next();
                System.out.println("Ingrese el telefono del artista: ");
                long telefonoAux = scInfo.nextLong();
                Artista artistaNuevo = new Artista(cedulaAux, nombreAux, apellidoAux, telefonoAux);
                listaArtistas.add(artistaNuevo);
                System.out.println("Artista añadido con exito!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void modificarObra(ArrayList<Obra> listaObras) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Ingrese el codigo de la obra a modificar");
            long codigoAux = sc.nextLong();
            for (Obra obra : listaObras) {
                if (obra.getCodigoObra() == codigoAux) {
                    System.out.println("La obra solicitada es:");
                    System.out.println("1. Codigo: " + obra.getCodigoObra() + "\n2. Titulo: " + obra.getTitulo() + "\n3. Fecha: " + obra.getFecha() + "\n4. Precio de referencia: " + obra.getPrecioRef());
                    System.out.println("5. Dimensiones: " + obra.getDimensiones());
                    System.out.println("¿Cual dato desea modificar?");
                    int aux = sc.nextInt();
                    sc.nextLine();
                    if (aux == 1) {
                        System.out.println("Ingrese el nuevo codigo de la obra: ");
                        String codigoNuevo = sc.next();
                        for (Obra obras : listaObras) {
                            if (obras.getCodigoObra() == Long.parseLong(codigoNuevo)) {
                                throw new Exception("ERROR - El codigo ya existe");
                            }
                        }
                        if (Long.parseLong(codigoNuevo) < 0) {
                            throw new Exception("ERROR - Codigo negativo");
                        } else if (codigoNuevo.length() != 7) {
                            throw new Exception("ERROR - Codigo mayor a 7 digitos");
                        } else {
                            obra.setCodigoObra(Long.parseLong(codigoNuevo));
                            System.out.println("Codigo actualizado!");
                            return;
                        }
                    } else if (aux == 2) {
                        System.out.println("Ingrese el nuevo titulo de la obra: ");
                        String nombreNuevo = sc.nextLine();
                        obra.setTitulo(nombreNuevo);
                        System.out.println("Titulo actualizado!");
                        return;
                    } else if (aux == 3) {
                        System.out.println("Perdon, aun no se como trabajar con  las fehas :(");
                        return;
                    } else if (aux == 4) {
                        System.out.println("Ingrese el nuevo precio: ");
                        long precioNuevo = sc.nextLong();
                        if (precioNuevo < 0) {
                            throw new Exception("ERROR - Precio negativo");
                        } else {
                            obra.setPrecioRef(precioNuevo);
                            System.out.println("Precio actualizado!");
                            return;
                        }
                    } else if (aux == 5) {
                        System.out.println("Ingrese las nuevas dimensiones: ");
                        String dimenNuevo = sc.nextLine();
                        obra.setDimensiones(dimenNuevo);
                        System.out.println("Dimensiones actualizadas!");
                        return;
                    }
                }
            }
            System.out.println("La obra no se encuentra en el sistema");

        } catch (InputMismatchException e) {
            System.out.println("Debes insertar un número");
            sc.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void eliminarObra(ArrayList<Obra> listaObras) {
        List<Obra> obrasFinales = new ArrayList<>();
        boolean existe = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el codigo de la obra a eliminar");
        long codigoAux = sc.nextLong();
        for (Obra obra : listaObras) {
            if (codigoAux == obra.getCodigoObra()) {
                existe = true;
            }
        }
        if (existe) {
            for (Obra obra : listaObras) {
                if (codigoAux == obra.getCodigoObra()) {
                    obrasFinales.add(obra);

                }

            }
            listaObras.removeAll(obrasFinales);
            System.out.println("Obra removida con exito!");
        } else {
            System.out.println("No existe obra con este codigo, ninguna obra removida");
        }
    }

    public static void eliminarCliente(ArrayList<Cliente> listaClientes) {
        List<Cliente> clientesFinales = new ArrayList<>();
        boolean existe = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el codigo del cliente a eliminar");
        long codigoAux = sc.nextLong();
        for (Cliente cliente : listaClientes) {
            if (codigoAux == cliente.getCodigoCliente()) {
                existe = true;
            }
        }
        if (existe) {
            for (Cliente cliente : listaClientes) {
                if (codigoAux == cliente.getCodigoCliente()) {
                    clientesFinales.add(cliente);
                }
            }
            listaClientes.removeAll(clientesFinales);
            System.out.println("Cliente removido con exito!");
        } else {
            System.out.println("No existe cliente con este codigo, ningun cliente removido");
        }
    }

    public static void modificarCliente(ArrayList<Cliente> listaClientes) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Ingrese el codigo del cliente a modificar");
            long codigoAux = sc.nextLong();
            for (Cliente cliente : listaClientes) {
                if (cliente.getCodigoCliente() == codigoAux) {
                    System.out.println("El cliente solicitado es:");
                    System.out.println("1. Codigo: " + cliente.getCodigoCliente() + "\n2. Cedula: " + cliente.getCedula() + "\n3. Nombre: " + cliente.getNombre() + "\n4. Apellidos: " + cliente.getApellidos());
                    System.out.println("5. Direccion de entrega: " + cliente.getDireccionEntrega() + "\n6. Telefono: " + cliente.getTelefono());
                    System.out.println("¿Cual dato desea modificar?");
                    int aux = sc.nextInt();
                    sc.nextLine();
                    if (aux == 1) {
                        System.out.println("Ingrese el nuevo codigo del cliente: ");
                        String codigoNuevo = sc.next();
                        for (Cliente clientes : listaClientes) {
                            if (clientes.getCodigoCliente() == Long.parseLong(codigoNuevo)) {
                                throw new Exception("ERROR - El codigo ya existe");
                            }
                        }
                        if (Long.parseLong(codigoNuevo) < 0) {
                            throw new Exception("ERROR - Codigo negativo");
                        } else {
                            cliente.setCodigoCliente(Long.parseLong(codigoNuevo));
                            System.out.println("Codigo actualizado!");
                            return;
                        }
                    } else if (aux == 2) {
                        System.out.println("Ingrese la nueva cedula del cliente: ");
                        long cedulaNueva = sc.nextLong();
                        sc.nextLine();
                        for (Cliente clientes : listaClientes) {
                            if (clientes.getCedula() == cedulaNueva) {
                                throw new Exception("ERROR - Cedula ya existente");
                            }
                        }
                        cliente.setCedula(cedulaNueva);
                        System.out.println("Cedula actualizada!");
                        return;
                    } else if (aux == 3) {
                        System.out.println("Ingrese el nuevo nombre del cliente: ");
                        String nombreNuevo = sc.nextLine();
                        cliente.setNombre(nombreNuevo);
                        System.out.println("Nombre actualizado!");
                        return;
                    } else if (aux == 4) {
                        System.out.println("Ingrese los nuevos apellidos del cliente: ");
                        String apellidoNuevo = sc.nextLine();
                        cliente.setApellidos(apellidoNuevo);
                        System.out.println("Apellido(s) actualizado(s)!");
                        return;
                    } else if (aux == 5) {
                        System.out.println("Ingrese la nueva direccion de entrega: ");
                        String direccionNueva = sc.nextLine();
                        cliente.setDireccionEntrega(direccionNueva);
                        System.out.println("Direccion actualizada!");
                        return;
                    } else if (aux == 6) {
                        System.out.println("Ingrese el nuevo telefono del cliente: ");
                        long telefonoNuevo = sc.nextLong();
                        cliente.setTelefono(telefonoNuevo);
                        System.out.println("Telefono actualizado!");
                        return;
                    }
                }
            }
            System.out.println("El cliente no se encuentra en el sistema");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

    /*public static void eliminarCompra(Map<Long, Long> mapaCompras, ArrayList<Compra>listacompras){
        Scanner sc = new Scanner(System.in);
        boolean existeCompra = false;
        System.out.println("Ingrese el codigo de la compra a eliminar: ");
        long codigoAux = sc.nextLong();
        for (Compra compra : listacompras){
            if(codigoAux == compra.getCodigoCompra()){
                existeCompra = true;
            }
        }
        if(existeCompra){
            for (Compra compra : listacompras){
                if(codigoAux == compra.getCodigoCompra()){
                    clientesFinales.add(cliente);
                }
            }
            listaClientes.removeAll(clientesFinales);
            System.out.println("Cliente removido con exito!");
        }else{
            System.out.println("No existe cliente con este codigo, ningun cliente removido");
        }

    }*/




