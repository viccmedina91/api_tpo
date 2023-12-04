import React, { useState } from 'react';
import { SECCIONES } from './setting/constantes';

const BarraNavegacion = ({ usuario }) => {
    const [activeIndex, setActiveIndex] = useState(null);
    const handleToggle = (index) => {
        setActiveIndex((prevIndex) => (prevIndex === index ? null : index));
    };

    return (
        <div className="accordion" id="accordionExample">
            {SECCIONES.map((item, index) => (
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
        </div>
    )
};
export default BarraNavegacion;