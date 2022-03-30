import React, { useRef, useState } from 'react';
import EntryCard from "../components/EntryCard";
import InputGroup from '../components/InputGroup';
import Input from '../components/Input';
import Button from '../components/Button';
import { EntryPage, PageHeader } from './style';
import logo from '../assets/img/logo-md.png'
import { Link } from 'react-router-dom'
import { useAuth } from "../contexts/AuthContext"


function Singup() {

    const emailRef = useRef();
    const passwordRef = useRef();
    const passworConfirmRef = useRef();
    const { signup } = useAuth();
    const [error, setError] = useState();
    const [loading, setLoading] = useState(false);

    async function handleSubmit(e){
        e.preventDefault();

        // validações para criação de usuário
        if(passwordRef.current.value !== passworConfirmRef.current.value){
            return setError('As senhas são diferentes!');
        }

        try {
            setError('');
            setLoading(true);
            await signup(emailRef.current.value, passwordRef.current.value);
        } catch {
            setError('Erro ao criar conta!');
        }

        setLoading(false);
    }

    return ( 
        <EntryPage>
            <PageHeader to="/">
                <img src={logo} width={352} height={110}></img>
            </PageHeader>
            <EntryCard>
                <h2>Cadastre-se</h2>
                {error && <h3>{error}</h3>}
                <form>
                    <InputGroup>
                        <label htmlFor='login-email'>Email:</label>
                        <Input ref={emailRef} type="text" placeholder="nome@email.com" />
                    </InputGroup>
                    <InputGroup>
                        <label htmlFor='login-senha'>Senha:</label>
                        <Input ref={passwordRef} type="password" placeholder="senha" />
                    </InputGroup>  
                    <InputGroup>
                        <label htmlFor='login-senha2'>Repita a senha:</label>
                        <Input ref={passworConfirmRef} type="password" placeholder="senha" />
                    </InputGroup>                        
                    <Button disabled={loading} type="submit" full>Salvar</Button>              
                </form>
                <span>
                    Já possui uma conta? <Link to="/login">Log in</Link>
                </span>
            </EntryCard>
        </EntryPage>
     );
}

export default Singup;