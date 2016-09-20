const {Button} = ReactBootstrap;

export const wellStyles = {maxWidth: 400, margin: '0 auto 10px'};

export const buttonsInstance = (
    <div className='well' style={wellStyles}>
        <Button bsStyle='primary' bsSize='large' block>Block level button</Button>
        <Button bsSize='large' block>Block level button</Button>
    </div>
);

React.render(buttonsInstance, document.getElementById("app"));