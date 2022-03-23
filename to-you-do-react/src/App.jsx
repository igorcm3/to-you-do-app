import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import {GlobalStyle} from './styles/globalStyles.js'
import Home from './pages/Home.js';
import Login from './pages/Login.js';

function App() {

  return (
      
      <BrowserRouter>
      <GlobalStyle />
            <Routes>
                <Route  path="/" element={<Home />} />
                <Route  path="/login" element={<Login />} />
            </Routes>
        </BrowserRouter>
  )
}

export default App;
