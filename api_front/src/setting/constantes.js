
export const ESTADOS_RECLAMO = [
    { id: 1, descripcion: 'Nuevo' },
    { id: 2, descripcion: 'Abierto' },
    { id: 3, descripcion: 'En proceso' },
    { id: 4, descripcion: 'Desestimado' },
    { id: 5, descripcion: 'Anulado' },
    { id: 6, descripcion: 'Terminado' },
];

export const ESPACIOS_COMUNES = [
    { id: 1, descripcion: 'Pasillo Central' },
    { id: 2, descripcion: 'Jardín' },
    { id: 3, descripcion: 'Escaleras' },
    { id: 4, descripcion: 'Ascensor' },
    { id: 5, descripcion: 'Terraza' },
];

export const FORMATO_IMAGENES = [
    { id: 1, descripcion: 'JPG' },
    { id: 2, descripcion: 'PNG' },
];

export const SECCIONES = [
    {
        title: 'Gestión de Edificio',
        content: ' ',
        subSections: [
            { nombre: 'Listar Edificios', url: '/edificio/listar' },
            { nombre: 'Buscar Edificio por código', url: '/edificio/buscar' },
            { nombre: 'Listar los Edificios con sus unidades', url: '/edificio/con/unidades' },
            { nombre: 'Listar Inquilinos por Edificio', url: '/edificio/inquilinos' },
            { nombre: 'Listar habilitados por Edificio', url: '/edificio/habilitados' },
            { nombre: 'Unidades por Edificio', url: '/edificio/unidades' },
            { nombre: 'Dueños por Edificio', url: '/edificio/duenio' },
            { nombre: 'Crear Edificio', url: '/edificio/agregar' },
            { nombre: 'Modificar Edificio', url: '/edificio/modificar' },
            { nombre: 'Eliminar Edificio', url: '/edificio/eliminar' },
        ],
    },
    {
        title: 'Gestión de Unidades',
        content: ' ',
        subSections: [
            { nombre: 'Buscar Unidad', url: '/unidad/buscar' },
            { nombre: 'Buscar Dueños por Unidad', url: '/unidad/duenios' },
            { nombre: 'Buscar Inquilinos por Unidado', url: '/unidad/inquilinos' },
            { nombre: 'Crear Unidado', url: '/unidad/crear' },
            { nombre: 'Unidades por Edificio', url: '/edificio/unidades' },
            { nombre: 'Transferir Unidad', url: '/unidad/modificar' },
            { nombre: 'Crear Edificio', url: '/unidad/transferir' },
            { nombre: 'Agregar Duenio a Unidad', url: '/unidad/agregar/duenio/unidad' },
            { nombre: 'Agregar Inquilino a Unidad', url: '/unidad/agregar/inquilino/unidad' },
            { nombre: 'Liberar Unidad', url: '/unidad/liberar' },
            { nombre: 'Habitar Unidad', url: '/unidad/habitar' },
        ]
    },
    {
        title: 'Gestión de Reclamos',
        content: ' ',
        subSections: [
            { nombre: 'Listar Reclamos por Edificio', url: '/reclamos/edificio' },
            { nombre: 'Listar Reclamos por Unidad', url: '/reclamos/unidad' },
            { nombre: 'Buscar Reclamos por Nro.', url: '/reclamos/nro' },
            { nombre: 'Buscar Reclamos por Documento', url: '/reclamos/persona' },
            { nombre: 'Crear Reclamo', url: '/reclamos/crear' },
            { nombre: 'Agregar Imagen a Reclamo', url: '/reclamos/agregar/imagen' },
            { nombre: 'Cambiar de estado a Reclamo', url: '/reclamos/actualizar/estado' },
        ]
    },
    {
        title: 'Gestión de Personas',
        content: ' ',
        subSections: [
            { nombre: 'Listar todas las Personas', url: '/persona/listar' },
            { nombre: 'Crear Persona', url: '/persona/crear' },
            { nombre: 'Eliminar Persona', url: '/persona/eliminar' },
            { nombre: 'Modificar Persona', url: '/persona/modificar' },
        ]
    },

];