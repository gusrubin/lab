extern crate gtk;
use gtk::prelude::*;
use gtk::{Button, Window, WindowType};

fn main() {
    // Inicializa o GTK
    gtk::init().expect("Failed to initialize GTK.");

    // Cria a janela
    let window = Window::new(WindowType::Toplevel);
    window.set_title("Hello, World!");
    window.set_default_size(350, 70);

    // Cria um botão
    let button = Button::new_with_label("Clique aqui!");

    // Adiciona o botão à janela
    window.add(&button);

    // Define a ação do botão ao ser clicado
    button.connect_clicked(|_| {
        println!("Hello, World!");
    });

    // Exibe todos os elementos
    window.show_all();

    // Executa o loop principal do GTK
    gtk::main();
}