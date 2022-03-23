import React from 'react';
import EntryCard from "../components/EntryCard";
import InputGroup from '../components/InputGroup';
import Input from '../components/Input';
import Button from '../components/Button';
import { EntryPage, PageHeader } from './style';


function Login(){
    return (
        <EntryPage>
            <PageHeader to="/">Logo maneira</PageHeader>
            <EntryCard>
                <h2>Log in</h2>
                <form onSubmit={(e) => e.preventDefault()}>
                    <InputGroup>
                        <label htmlFor='login-email'>Endereço de email</label>
                        <Input type="text" placeholder="nome@email.com" id="login-email" />
                    </InputGroup>
                    <InputGroup>
                        <label htmlFor='login-senha'>Senha</label>
                        <Input type="password" placeholder="senha" id="login-senha" />
                    </InputGroup>      
                    <Button type="submit" full>Entrar</Button>              

                </form>
            </EntryCard>
        </EntryPage>


    );

}

export default Login;