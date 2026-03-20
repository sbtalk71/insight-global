import styles from "./hello.css.js";

export function HelloJsCss(){
    return(
        <>
        <p style={styles.hello}>This is External JS based Styling</p>
        </>
    );
}