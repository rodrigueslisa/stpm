export const AUTH = "/api/auth";

export function saveAuth({ token, role, name, email }) {
  localStorage.setItem("token", token);
  localStorage.setItem("role", role);
  if (name) localStorage.setItem("name", name);
  if (email) localStorage.setItem("email", email);
}

export function getAuth() {
  return {
    token: localStorage.getItem("token"),
    role: localStorage.getItem("role"),
    name: localStorage.getItem("name"),
    email: localStorage.getItem("email")
  };
}

export function logout() {
  localStorage.clear();
  window.location.href = "/";
}

export function goByRole() {
  const role = localStorage.getItem("role");
  switch (role) {
    case "STUDENT":
      window.location.href = "/student/dashboard.html";
      break;
    case "EMPLOYER":
      window.location.href = "/employer/dashboard.html";
      break;
    case "UNIVERSITY":
      window.location.href = "/university/dashboard.html";
      break;
    default:
      logout();
  }
}
