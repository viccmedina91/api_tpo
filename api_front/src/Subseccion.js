
import { Link } from 'react-router-dom';
import { Dropdown } from 'react-bootstrap';

const Subseccion = ({ title, to }) => (
    <Dropdown.Item as={Link} to={to}>{title}</Dropdown.Item>
);

export default Subseccion;