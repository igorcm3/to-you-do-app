import RobotoWoff from "../assets/fonts/roboto-v29-latin-regular.woff";
import RobotoWoff2 from "../assets/fonts/roboto-v29-latin-regular.woff2";

const FontStyles = createGlobalStyle`

@font-face {
  font-family: 'Roboto';
  src: url(${RobotoWoff2}) format('woff2'),
       url(${RobotoWoff}) format('woff');
}
`;

export default FontStyles;