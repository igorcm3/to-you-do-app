import React, { useState } from 'react'
import Login from './pages/Login/Login.js'
import {GlobalStyle} from './styles/globalStyles.js'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <GlobalStyle />
      <Login/>
    </>
  )
}

export default App
