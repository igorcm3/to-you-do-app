import styled, { createGlobalStyle } from 'styled-components';

export const GlobalStyle = createGlobalStyle`
  * {
    padding: 0;
    margin: 0;
    box-sizing: border-box;
    background: #ffff;
  }

  body, html, #root {
    height: 100%;
    font-family: -apple-system, Ubuntu , BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;;
  }
`;

export const Wrapper = styled.section`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  width: 100%;
`;

export const Form = styled.form`
  margin: 0 auto;
  width: 100%;
  max-width: 520px;
  padding: 1.3rem;
  display: flex;
  flex-direction: column;
  position: relative;
`;

export const Button = styled.button`
  border-radius: 4px;
  background: ${({primary}) => (primary ?  '#223759' : '#2B4570')};
  white-space: nowrap;
  padding: ${({big}) => (big ? '12px 64px' : '10px 20px' )};
  color: #fff;
  font-size: ${({fontBig}) => (fontBig ? '20px': '16px')};
  outline: none;
  border: none;
  max-width: 100%;
  cursor: pointer;

  &:hover {
    transition: all 0.3 ease-out;
    background: #fff;
    background: ${({primary}) => (primary ?  '#2B4570' : '#223759')};

  }
  
`;

export const Input = styled.input`
  max-width: 100%;
  padding: 11px 13px;
  background: #fff;
  color: #223759;
  margin-bottom: 0.9rem;
  border-radius: 4px;
  outline: 0;
  border: 1px solid rgba(245, 245, 245, 0.7);
  font-size: 14px;
  transition: all 0.3s ease-out;
  box-shadow: 0 0 3px rgba(0, 0, 0, 0.1), 0 1px 1px rgba(0, 0, 0, 0.1);
  :focus,
  :hover {
    box-shadow: 0 0 3px rgba(0, 0, 0, 0.15), 0 1px 5px rgba(0, 0, 0, 0.1);
  }
`;

 
export default GlobalStyle;