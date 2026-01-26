
function videoCard(titulo, id) {
  const url = `https://www.youtube.com/watch?v=${id}`;
  const thumb = `https://i.ytimg.com/vi/${id}/hqdefault.jpg`;

  return `
  <div class="col-12 col-md-6">
    <div class="video-card">
      <h5 class="text-center mb-2">${titulo}</h5>

      <div class="embed-wrap">
        <div class="ratio ratio-16x9">
          <iframe
            class="yt-embed"
            src="https://www.youtube-nocookie.com/embed/${id}?rel=0&modestbranding=1"
            title="${titulo}"
            loading="lazy"
            referrerpolicy="strict-origin-when-cross-origin"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
            allowfullscreen></iframe>
        </div>
      </div>

      <a class="yt-fallback" href="${url}" target="_blank" rel="noopener">
        <img src="${thumb}" alt="${titulo}">
        <span>Ver en YouTube</span>
      </a>
    </div>
  </div>
  `;
}

function activarFallbackVideos() {
  document.querySelectorAll(".yt-embed").forEach((iframe) => {
    let cargo = false;

    iframe.addEventListener("load", () => {
      cargo = true;
      const card = iframe.closest(".video-card");
      if (card) card.classList.add("embed-ok");
    });


    setTimeout(() => {
      if (!cargo) {
        const card = iframe.closest(".video-card");
        if (card) card.classList.add("embed-fail");
      }
    }, 2500);
  });
}

const secciones = {
  biografia: `
  <div class="biografia-contenido">
    <div class="biografia-header">
      <h1 class="bio-nombre">JAIVER CASTRO</h1>
      <h2 class="bio-subtitulo">BIOGRAFÍA</h2>
    </div>
    <div class="biografia-fila">
      <div class="columna-texto">
        <p>JAIVER CASTRO GUERRERO, conocido artísticamente como EL ZURDO DE ORO, nació en Trinidad, Casanare...</p>
        <p>Con más de 50 canciones grabadas, de las cuales 25 son de su autoría...</p>
      </div>
      <div class="columna-imagen">
        <img src="foto.biografia.jpg" alt="Jaiver Castro" class="img-bio">
      </div>
      <div class="columna-texto">
        <p>Además de su carrera como cantante y compositor...</p>
        <p>Como administrador de empresas...</p>
        <p>Hoy, el Zurdo de Oro mantiene viva la tradición...</p>
      </div>
    </div>
  </div>

  <section class="trayectoria">
    <div class="trayectoria-contenido">
      <div class="trayectoria-texto">
        <h2>TRAYECTORIA</h2>
        <p><strong>FESTIVAL ESTUDIANTIL:</strong><br>2° puesto modalidad: voz recia – Maní, Casanare (1995).</p>
        <p><strong>ESTRELLAS LLANERAS:</strong><br>Modalidad: voz pasaje – Aguazul, Casanare (1999).</p>
        <p><strong>FESTIVAL EL GARCERO DEL LLANO:</strong><br>1° puesto modalidad: voz pasaje – Yopal, Casanare (2001).</p>
        <p><strong>FESTIVAL DEPARTAMENTAL EL GARCERO DEL LLANO:</strong><br>Primer puesto modalidad: Mejor Bandolista – Yopal, Casanare (2002/2003).</p>
        <p><strong>CONCURSO MEJOR TEMA INÉDITO:</strong><br>Programa Llano Adentro – Segundo puesto (2003).</p>
      </div>
      <div class="trayectoria-imagen">
        <img src="fotojaivercerca.jpg" alt="Jaiver Castro">
      </div>
    </div>
  </section>
  `,

    videos: `
  <section class="container mt-4 videos-section">
    <h2 class="text-center mb-4">VIDEOS OFICIALES</h2>

    <div class="row g-4">
      ${videoCard("Soy Acacireño", "6EBzzt31POQ")}
      ${videoCard("La Ingrata", "6EBzzt31POQ")}
      ${videoCard("Se Marchó Mamá", "_JoiSc8_AZ0")}
      ${videoCard("Clásicos de la Música Llanera", "npzh4msgGw4")}
      ${videoCard("Festival del Retorno", "ZxCusI4W5Os")}
    </div>
  </section>
  `,

  contrataciones: `
  <div class="contrataciones-contenido">
    <h2>CONTRATACIONES</h2>

    <div>
      <label>Nombre del contratante:</label>
      <input type="text" id="nombreContratante" placeholder="Escribe tu nombre">
    </div>

    <div style="margin-top:20px;">
      <p>El contratante es: <strong><span id="verNombre">________________</span></strong></p>
    </div>
  </div>
  `
};

function mostrarSeccion(seccion) {
  const contenidoEPK = document.getElementById("contenidoEPK");
  if (!contenidoEPK) return;

  contenidoEPK.innerHTML = secciones[seccion] || "<p>Sección no disponible</p>";

  if (seccion === "videos") {
    setTimeout(activarFallbackVideos, 50);
  }

   if (seccion === "contrataciones") {
    const inputNombre = document.getElementById("nombreContratante");
    const verNombre = document.getElementById("verNombre");

    if (inputNombre && verNombre) {
      inputNombre.addEventListener("input", () => {
        verNombre.textContent = inputNombre.value || "________________";
      });
    }
  }
}

document.addEventListener("DOMContentLoaded", () => {
  mostrarSeccion("biografia");

  document.querySelectorAll(".btn-epk").forEach((boton) => {
    boton.addEventListener("click", () => {
      const seccion = boton.dataset.seccion;
      mostrarSeccion(seccion);
    });
  });
});


function calcularContratacion() {
 
}

agenda: `
<section class="container mt-4" style="background:#ffffff; padding:30px; border-radius:12px;">
  <h2 class="text-center mb-4">AGENDA DE PRESENTACIONES</h2>

  <p class="text-center mb-4">
    Próximas fechas y eventos de <strong>El Zurdo de Oro</strong>.
  </p>

  <div class="row g-4">

    <div class="col-md-6 col-lg-4">
      <div class="card shadow-sm h-100">
        <div class="card-body">
          <h5 class="card-title">Festival Llanero</h5>
          <p class="card-text"><strong>Fecha:</strong> 25 de enero de 2026</p>
          <p class="card-text"><strong>Ciudad:</strong> Villavicencio, Meta</p>
          <span class="badge bg-success">Confirmado</span>
        </div>
      </div>
    </div>

    <div class="col-md-6 col-lg-4">
      <div class="card shadow-sm h-100">
        <div class="card-body">
          <h5 class="card-title">Evento Privado</h5>
          <p class="card-text"><strong>Fecha:</strong> 1 de febrero de 2026</p>
          <p class="card-text"><strong>Ciudad:</strong> Bogotá D.C.</p>
          <span class="badge bg-warning text-dark">Reservado</span>
        </div>
      </div>
    </div>

    <div class="col-md-6 col-lg-4">
      <div class="card shadow-sm h-100">
        <div class="card-body">
          <h5 class="card-title">Serenata Especial</h5>
          <p class="card-text"><strong>Fecha:</strong> 14 de febrero de 2026</p>
          <p class="card-text"><strong>Ciudad:</strong> Yopal, Casanare</p>
          <span class="badge bg-success">Confirmado</span>
        </div>
      </div>
    </div>

    <div class="col-md-6 col-lg-4">
      <div class="card shadow-sm h-100">
        <div class="card-body">
          <h5 class="card-title">Festival Cultural</h5>
          <p class="card-text"><strong>Fecha:</strong> 28 de febrero de 2026</p>
          <p class="card-text"><strong>Ciudad:</strong> Casanare</p>
          <span class="badge bg-secondary">Disponible</span>
        </div>
      </div>
    </div>

  </div>
</section>
`
botones.forEach(boton => {
  boton.addEventListener("click", (e) => {
    e.preventDefault();

    const seccion = boton.dataset.seccion;

       const imagen = document.querySelector(".imagen-contenedor");
    if (imagen) {
      imagen.style.display = (seccion === "agenda") ? "none" : "block";
    }

    contenidoEPK.innerHTML = secciones[seccion] || "<p>Sección no disponible</p>";

        contenidoEPK.scrollIntoView({ behavior: "smooth" });
  });
});
