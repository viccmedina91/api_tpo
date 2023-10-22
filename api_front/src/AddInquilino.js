import FormNewDuenioInquilino from './Forms/FormNewDuenioInquilino';

function AddInquilino() {

    const handleSubmit = (newItem) => {
        console.log(newItem);
        // Realizar la solicitud POST al backend utilizando fetch
        fetch('http://localhost:8080/inquilino/crear', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(newItem),
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then((data) => {
                // Realizar acciones adicionales después de la inserción exitosa
                console.log('Elemento agregado exitosamente:', data);
                // Restablecer los campos del formulario

            })
            .catch((error) => {
                console.error('Error al agregar el elemento:', error);
            });
    };

    return (
        <div>
            <h2>Agregar un Nuevo Inquilino</h2>
            <FormNewDuenioInquilino onSubmit={handleSubmit} />
        </div>
    );
}

export default AddInquilino;
