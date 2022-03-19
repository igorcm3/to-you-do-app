import { useState } from 'react'
import GlobalStyle from './styles/globalStyles.js'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="App">
      <GlobalStyle />
      <h1>Olá mundo!</h1>
    </div>
  )
}

export default App
