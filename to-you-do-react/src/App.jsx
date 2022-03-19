import { useState } from 'react'
import GlobalStyle from './styles/globalStyles.js'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="App">
      <GlobalStyle />
      <Button text="teste" />
    </div>
  )
}

export default App
