// ------- GLOBAL CONFIG -------
export const API = "/api";          // base for all modules
export const AUTH = "/api/auth";    // auth module (login/signup)
const LS_TOKEN = "stpm_token";
const LS_ROLE  = "stpm_role";

// ------- AUTH HELPERS -------
export function saveAuth({token, role}) {
  if (token) localStorage.setItem(LS_TOKEN, token);
  if (role)  localStorage.setItem(LS_ROLE, role);
}
export function getToken() { return localStorage.getItem(LS_TOKEN); }
export function getRole()  { return localStorage.getItem(LS_ROLE);  }
export function logout() { localStorage.removeItem(LS_TOKEN); localStorage.removeItem(LS_ROLE); location.href="/index.html"; }

// ------- FETCH HELPERS -------
export async function api(path, opts={}) {
  const headers = Object.assign({"Content-Type":"application/json"}, opts.headers||{});
  const token = getToken();
  if (token) headers["Authorization"] = `Bearer ${token}`;
  const res = await fetch(path.startsWith("/api")? path : `${API}${path}`, {...opts, headers});
  if (!res.ok) throw new Error(await res.text());
  const ct = res.headers.get("content-type")||"";
  return ct.includes("application/json") ? res.json() : res.text();
}

// For uploads
export async function apiUpload(path, formData) {
  const token = getToken();
  const headers = token ? { "Authorization": `Bearer ${token}` } : {};
  const res = await fetch(`${API}${path}`, { method:"POST", headers, body:formData });
  if (!res.ok) throw new Error(await res.text());
  return res.json();
}

// ------- ROUTING HELPERS -------
export function goByRole(role) {
  const r = role || getRole();
  if (r === "STUDENT")   location.href="/student/dashboard.html";
  else if (r === "EMPLOYER") location.href="/employer/dashboard.html";
  else if (r === "UNIVERSITY") location.href="/university/dashboard.html";
  else location.href="/index.html";
}

// role guard
export function guardRole(required) {
  const r = getRole();
  if (!r) return location.href="/index.html";
  if (Array.isArray(required) ? !required.includes(r) : r!==required) {
    return goByRole(r);
  }
}

// small helpers
export function qs(id){return document.querySelector(id)}
export function qsa(sel){return [...document.querySelectorAll(sel)]}
export function formatDate(s){return new Date(s).toLocaleString()}
