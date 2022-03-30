import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import {GlobalStyle} from './styles/globalStyles.js'
import Home from './pages/Home.js';
import Login from './pages/Login.js';
import Signup from './pages/Signup.js';
import { AuthProvider } from './contexts/AuthContext.js';

function App() {

  return (
    <AuthProvider>
      <BrowserRouter>
        <GlobalStyle />
        <Routes>
            <Route  path="/" element={<Home />} />
            <Route  path="/login" element={<Login />} />
            <Route  path="/singup" element={<Singup />} />
        </Routes>
      </BrowserRouter>
    </AuthProvider>
  )
}

export default App;
