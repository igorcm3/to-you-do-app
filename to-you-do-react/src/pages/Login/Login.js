import React from "react";
import { Button, Input, Form, Wrapper } from "../../styles/globalStyles";

function Login(){
    return (
        <Wrapper>
        <Form >
          <Input
            type="email"
            name="email"
            //value={dados.email}
            //onChange={handleChange}
          />
          <Input
            type="password"
            name="password"
            //value={dados.password}
            //onChange={handleChange}
          />
          <Button>Entrar</Button>
        </Form>
      </Wrapper>

    );    


}

export default Login;