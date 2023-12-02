import React from 'react';

function ShowList({ result }) {
    return (
        <div className="alert alert-success" role="alert">
            {result}
        </div>
    );

}

export default ShowList;