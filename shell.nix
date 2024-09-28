
{ pkgs ? import <nixpkgs> {} }:
let
  libs = with pkgs; [
    kotlin
    jetbrains.jdk
  ];
in
pkgs.mkShell {
  nativeBuildInputs = with pkgs; [
    jetbrains.idea-community
  ];

  buildInputs = libs;
  LD_LIBRARY_PATH = pkgs.lib.makeLibraryPath libs;
  shellHook = ''
    alias ii='${pkgs.jetbrains.idea-community}/bin/idea-community'

    echo "Type 'ii' to launch Intellij"
  '';
}
