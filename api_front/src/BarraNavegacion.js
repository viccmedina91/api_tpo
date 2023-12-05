import React, { useState } from 'react';
import { SECCIONES, SECCIONES_USUARIO } from './setting/constantes';
import Logout from './Logout';

const BarraNavegacion = ({ usuario }) => {
    console.log("----------");
    console.log(usuario);
    const [activeIndex, setActiveIndex] = useState(null);
    const handleToggle = (index) => {
        setActiveIndex((prevIndex) => (prevIndex === index ? null : index));
    };
    let secciones;
    if (usuario === '1234') {
        secciones = SECCIONES;
    } else {
        secciones = SECCIONES_USUARIO;

    }

    return (
        <div className="accordion" id="accordionExample">
            {secciones.map((item, index) => (
                <div key={index} className="accordion-item">
                    <h2 className="accordion-header" id={`heading${index}`}>
                        <button
                            className={`accordion-button ${index === activeIndex ? 'active' : ''}`}
                            type="button"
                            onClick={() => handleToggle(index)}
                            data-bs-toggle="collapse"
                            data-bs-target={`#collapse${index}`}
                            aria-expanded={index === activeIndex}
                            aria-controls={`collapse${index}`}
                        >
                            {item.title}
                        </button>
                    </h2>
                    <div
                        id={`collapse${index}`}
                        className={`accordion-collapse collapse ${index === activeIndex ? 'show' : ''}`}
                        aria-labelledby={`heading${index}`}
                        data-bs-parent="#accordionExample"
                    >
                        <div className="accordion-body">
                            {item.content}
                            {item.subSections && (
                                <ul>
                                    {Object.values(item.subSections).map((subSection) => (
                                        <li key={subSection.url}>
                                            <a href={subSection.url}>{subSection.nombre}</a>
                                        </li>
                                    ))}
                                </ul>
                            )}
                        </div>
                    </div>
                </div>
            ))}
            <Logout></Logout>
        </div>
    )
};
export default BarraNavegacion;