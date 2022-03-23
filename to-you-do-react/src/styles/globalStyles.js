import styled, { createGlobalStyle } from 'styled-components';

export const GlobalStyle = createGlobalStyle`
  * {
    padding: 0;
    margin: 0;
    outline: 0;
    text-decoration: none;
    box-sizing: border-box;    
  }

  body, html, #root {
    color: #333;
    font-family: -apple-system, 'Ubuntu' , BlinkMacSystemFont, "Segoe UI", 'Roboto', 'Oxygen', 'Cantarell', "Open Sans", "Helvetica Neue", sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
  }
`;

 
export default GlobalStyle;